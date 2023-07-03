/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
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
public class CRUDCliente {
     private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
    
    
    public DefaultTableModel mostrarDatos(){
        ResultSet rs;
       DefaultTableModel modelo;
       String[] titulos = {"IdCliente", "Nombre", "Apellido", "Genero", "Cedula", "Direccion", "Telefono"};
       String[] registro = new String[7];
       
       modelo = new DefaultTableModel(null, titulos);
               
       try{
            CallableStatement cbstc = cn.prepareCall("{call MostrarClientes}");
            rs = cbstc.executeQuery();
           
            while (rs.next()) {
                registro[0] = rs.getString("IdCliente");
                   registro[1] = rs.getNString("Nombre");
                   registro[2] = rs.getNString("Apellido");
                   registro[3] = rs.getNString("Genero");
                   registro[4] = rs.getNString("Cedula");
                   registro[5] = rs.getNString("Direccion");
                   registro[6] = rs.getString("Telefono");
                   
                   
                   modelo.addRow(registro);
            }
            return modelo;
            
       }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
           return null;
       }
    }
    
    public void Agregar (Cliente cli){
        try{
            CallableStatement cbst = cn.prepareCall("{call InsertarCliente (?,?,?,?,?,?)}");
            cbst.setString(1, cli.getNombre());
            cbst.setString(2, cli.getApellido());
            cbst.setString(3, cli.getGenero());
            cbst.setString(4, cli.getCedula());
            cbst.setString(5, cli.getDireccion());
            cbst.setString(6, cli.getTelefono());
            cbst.execute();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public boolean verificarDatos(String dato){
        ResultSet rs;
        try{
            CallableStatement call = cn.prepareCall("{call VerificarCliente(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();
            return rs.next();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    public void eliminar(String IdCliente){
         
          try{
               CallableStatement cbst = cn.prepareCall("{call Eliminar_Cliente(?)}");
            cbst.setString(1, IdCliente);
            cbst.executeUpdate();
            
          }catch (SQLException e) {
               JOptionPane.showMessageDialog(null, e);
          }
     }
    
    public void actualizar(Cliente cli){
        try{
            CallableStatement cbst = cn.prepareCall("{call ACtualizarCliente(?,?,?,?,?,?)}");
            cbst.setString(1, cli.getNombre());
            cbst.setString(2, cli.getApellido());
            cbst.setString(3, cli.getGenero());
            cbst.setString(4, cli.getCedula());
            cbst.setString(5, cli.getDireccion());
              cbst.setString(6, cli.getTelefono());
            
                    
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        
        }
    }
}
