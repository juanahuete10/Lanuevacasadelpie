/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Producto;
import Modelo.Venta;
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
public class CRUDVenta {
    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
    
    public DefaultTableModel mostrarDatos(){
        ResultSet rs;
       DefaultTableModel modelo;
       String[] titulos = {"CodigoVenta", "NombreCliente", "Fecha"};
       String[] registro = new String[6];
       
       modelo = new DefaultTableModel(null, titulos);
       
       try{
            CallableStatement cbstc = cn.prepareCall("{call MostrarVenta}");
            rs = cbstc.executeQuery();

        while (rs.next()){
            registro[0] = rs.getString("CodigoVenta");
                   registro[1] = rs.getNString("NombreCliente");
                   registro[2] = rs.getNString("Fecha");
                   
                   modelo.addRow(registro);
        }
        return modelo;
        
       }catch (SQLException e){
           JOptionPane.showMessageDialog(null, e);
           return null;
       }
    }
    
    public void Agregar (Venta ven){
        try{
            CallableStatement cbst = cn.prepareCall("{call CrearVenta(?,?,?,?,?,?)}");
            cbst.setInt(ven.getCodigoVenta(), 1);
            cbst.setString(2, ven.getNommbreCliente());
            cbst.setInt(ven.getFecha(), 3);
            cbst.executeUpdate();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }   
    }
    
    public void eliminar(int CodigoVenta){
        try{
            CallableStatement cbst = cn.prepareCall("{call EliminarVenta(?)}");
            cbst.setInt(CodigoVenta, 1);
            cbst.executeUpdate();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    public void actualizar(Venta ven){
        try{
            CallableStatement cbst = cn.prepareCall("{callModificarPro(?,?,?)}");
            cbst.setInt(ven.getCodigoVenta(), 1);
            cbst.setString(2, ven.getNommbreCliente());
            cbst.setInt(ven.getFecha(), 3);
            cbst.executeUpdate();
             
        }catch (SQLException e){
           JOptionPane.showMessageDialog(null, e);
         
        }
        
    }
}
