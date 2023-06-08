/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Categoria;
import Modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
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
            "PrecioCompra", "Talla", "Descripcion", "NombreProveedor",
            "ApellidoProveedor", "Categoria", "NombreMarca"};
        String[] registro = new String[10];

        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement cbstc = cn.prepareCall("{call MostrarProducto}");
            rs = cbstc.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("IdProducto");
                registro[1] = rs.getString("PrecioVenta");
                registro[2] = rs.getString("CantidadDisponible");
                registro[3] = rs.getString("PrecioCompra");
                registro[4] = rs.getString("Talla");
                registro[5] = rs.getString("Descripcion");
                registro[6] = rs.getString("NombreProveedor");
                registro[7] = rs.getString("ApellidoProveedor");
                registro[8] = rs.getString("Categoria");
                registro[9] = rs.getString("NombreMarca");

                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
//    public ArrayList mostrarDatosCombo(){
//        ArrayList<Producto> Producto = new ArrayList();
//        
//        try{
//            CallableStatement cbstc = cn.prepareCall("{call MostrarProducto}");
//            ResultSet rs = cbstc.executeQuery();
//            while (rs.next()){
//                Producto pro = new Producto();
//                pro.getIdProducto(rs.getString(IdProducto));
//                
//            }
//        }
//    }

    public void Agregar(Producto pro) {
        try {
            CallableStatement cbst = cn.prepareCall("{call AgregarProducto(?,?,?,?,?,?,?)}");
            cbst.setString(1, pro.getIdProducto());
            cbst.setInt(2,pro.getPrecioVenta());
            cbst.setInt(3,pro.getCantidadDisponible());
            cbst.setInt(4,pro.getPrecioCompra());
            cbst.setString(5, pro.getCategoria());
            cbst.setString(6, pro.getDescripcion());
            cbst.setString(7, pro.getTalla());
            cbst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public boolean verificarDatos(String dato){
        ResultSet rs;
        try{
            CallableStatement call = cn.prepareCall("{call Producto(?)}");
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
            CallableStatement cbst = cn.prepareCall("{call EliminarProducto(?)}");
            cbst.setString(1, IdProducto);
            cbst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void actualizar(Producto pro) {
        try {
            CallableStatement cbst = cn.prepareCall("{call ModificarPro(?,?,?,?,?,?,?)}");
            cbst.setString(1, pro.getIdProducto());
            cbst.setInt(pro.getPrecioVenta(), 2);
            cbst.setInt(pro.getCantidadDisponible(), 3);
            cbst.setInt(pro.getPrecioCompra(), 4);
            cbst.setString(5, pro.getCategoria());
            cbst.setString(6, pro.getDescripcion());
            cbst.setString(7, pro.getTalla());
            cbst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    
    
    public DefaultComboBoxModel<Categoria> Llenar() {
    DefaultComboBoxModel<Categoria> modelo = new DefaultComboBoxModel<>();
    modelo.addElement(new Categoria(-1, "Categoria"));

    try {
        CallableStatement cbstc = cn.prepareCall("{call LlenarCategoria}");
        ResultSet rs = cbstc.executeQuery();
        while (rs.next()) {
            int IdCategoria = rs.getInt(1);
            String nombre_categoria = rs.getString(2);
            Categoria categoria = new Categoria(IdCategoria, nombre_categoria);
            modelo.addElement(categoria);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
 
    return modelo;
}
    
}
