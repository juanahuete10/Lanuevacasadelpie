/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Login;
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
public class CRUDLogin {
     private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();

    public DefaultTableModel mostrarDatos(){
         ResultSet rs;
       DefaultTableModel modelo;
       String[] titulos = {"Usuario", "Contraseña"};
       String[] registro = new String[6];
       
       modelo = new DefaultTableModel(null, titulos);
       
       try{
            CallableStatement cbstc = cn.prepareCall("{call MostrarProducto}");
            rs = cbstc.executeQuery();
            
            while (rs.next()){
                registro[0] = rs.getString("Usuario");
                   registro[1] = rs.getNString("Contraseña");
                   
                    modelo.addRow(registro);
            }
            return modelo;
            
       } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
           return null;
       }
    }
    
    public void Agregar (Login log){
        try{
            CallableStatement cbst = cn.prepareCall("{call CrearLogin(?,?)}");
            cbst.setInt(log.getUsuario(), 1);
            cbst.setInt(log.getContraseña(), 2);
            cbst.executeUpdate();
            
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void eliminar(int Usuario){
        try{
            CallableStatement cbst = cn.prepareCall("{call EliminarLogin(?)}");
            cbst.setInt(Usuario, 1);
            cbst.executeUpdate();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    
    public void actualizar(Login log){
        try{
            CallableStatement cbst = cn.prepareCall("{callModificarLog(?,?)}");
            cbst.setInt(log.getUsuario(), 1);
            cbst.setInt(log.getContraseña(), 2);
            cbst.executeUpdate();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }

}
