/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

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
       String[] titulos = {"CodigoVenta", "IdCliente", "IdEmpleado", "Fecha"};
       String[] registro = new String[4];
       
       modelo = new DefaultTableModel(null, titulos);
       
       try{
            CallableStatement cbstc = cn.prepareCall("{call MostrarVentas}");
            rs = cbstc.executeQuery();

        while (rs.next()){
            registro[0] = rs.getString("CodigoVenta");
                   registro[1] = rs.getNString("IdCliente");
                   registro[2] = rs.getNString("IdEmpleado");
                   registro[3] = rs.getNString("Fecha");
                   
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
            CallableStatement cbst = cn.prepareCall("{call InsertarVenta(?,?,?)}");
            cbst.setInt(1, ven.getIdCliente());
            cbst.setInt(2, ven.getIdEmpleado());
            cbst.setInt(3, ven.getFecha());
            cbst.executeUpdate();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }   
    }
    
    public boolean verificarDatos(String dato){
        ResultSet rs;
        try{
            CallableStatement call = cn.prepareCall("{call VerificarVenta(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();
            return rs.next();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    public void eliminar(String CodigoVenta){
        try{
            CallableStatement cbst = cn.prepareCall("{call Eliminar_Venta(?)}");
            cbst.setString(1, CodigoVenta);
            cbst.executeUpdate();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    public void actualizar(Venta ven){
        try{
            CallableStatement cbst = cn.prepareCall("{call ActualizarVenta(?,?,?)}");
            cbst.setInt(1, ven.getIdCliente());
            cbst.setInt(2, ven.getIdEmpleado());
            cbst.setInt(3, ven.getFecha());
            cbst.executeUpdate();
             
        }catch (SQLException e){
           JOptionPane.showMessageDialog(null, e);
         
        }
        
    }
}
