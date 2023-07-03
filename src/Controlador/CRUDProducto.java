/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author personal
 */
public class CRUDProducto {
     private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();

    public DefaultTableModel mostrarDatos() {
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"IdProducto", "PrecioVenta", "CantidadDisponible", 
            "PrecioCompra", "Talla", "Descripcion", "Categoria", "IdMarca", "Marca", "Proveedor"};
        String[] registro = new String[10];

        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement cbstc = cn.prepareCall("{call MostrarProductos}");
            rs = cbstc.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("IdProducto");
                registro[1] = rs.getString("PrecioVenta");
                registro[2] = rs.getString("CantidadDisponible");
                registro[3] = rs.getString("PrecioCompra");
                registro[4] = rs.getString("Talla");
                registro[5] = rs.getString("Descripcion");
                registro[6] = rs.getString("Categoria");
                registro[7] = rs.getString("IdMarca");
                 registro[8] = rs.getString("Marca");
                  registro[9] = rs.getString("Proveedor");


                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    

    

    public void Agregar(Producto pro) {
        try {
            CallableStatement cbst = cn.prepareCall("{call InsertarProducto(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cbst.setInt(1,pro.getPrecioVenta());
            cbst.setInt(2,pro.getCantidadDisponible());
            cbst.setInt(3,pro.getPrecioCompra());
            cbst.setString(4, pro.getTalla());
            cbst.setString(5, pro.getDescripcion());
            cbst.setInt(6, pro.getIdCategorias());
            cbst.setInt(7, pro.getIdMarca());
            cbst.setString(8, pro.getMarca());
            cbst.setString(9, pro.getProveedor());
            cbst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public boolean verificarDatos(String dato){
        ResultSet rs;
        try{
            CallableStatement call = cn.prepareCall("{call VerificarProducto(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();
            return rs.next();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public void eliminar(String IdProducto) {

        try {
            CallableStatement cbst = cn.prepareCall("{call Eliminar_Producto(?)}");
            cbst.setString(1, IdProducto);
            cbst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void actualizar(Producto pro) {
        try {
            CallableStatement cbst = cn.prepareCall("{call ActualizarProducto(?,?,?,?,?,?,?,?,?,?)}");
            cbst.setInt(1, pro.getPrecioVenta());
            cbst.setInt(2, pro.getCantidadDisponible());
            cbst.setInt(3, pro.getPrecioCompra());
            cbst.setString(4, pro.getTalla());
            cbst.setString(5, pro.getDescripcion());
            cbst.setInt(6, pro.getIdCategorias());
            cbst.setInt(7, pro.getIdMarca());
            cbst.setString(8, pro.getMarca());
            cbst.setString(9, pro.getProveedor());
            
            cbst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
}
