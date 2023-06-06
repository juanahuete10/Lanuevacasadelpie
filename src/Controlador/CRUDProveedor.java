/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Proveedor;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author personal
 */
public class CRUDProveedor {
    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
    
    public DefaultTableModel mostrarDatos(){
        ResultSet rs;
       DefaultTableModel modelo;
       String[] titulos = {"IdProveedor", "Nombre", "Apellido", "Direccion", "Telefono"};
       String[] registro = new String[5];
       
       modelo = new DefaultTableModel(null, titulos);
       
       try{
           CallableStatement cbstc = cn.prepareCall("{call MostrarProveedores}");
            rs = cbstc.executeQuery();
            
             while (rs.next()) {
                 registro[0] = rs.getString("IdProveedor");
                   registro[1] = rs.getNString("Nombre");
                   registro[2] = rs.getNString("Apellido");
                   registro[3] = rs.getNString("Direccion");
                   registro[4] = rs.getString("Telefono");
                   
                   modelo.addRow(registro);
             }
             return modelo;
       }catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e);
             
    }
        return null;
  }
    
     public void Agregar (Proveedor prov){
        try{
            CallableStatement cbst = cn.prepareCall("{call InsertarProveedores(?,?,?,?,?)}");
            cbst.setString(1, prov.getIdProveedor());
            cbst.setString(2, prov.getNombre());
            cbst.setString(3, prov.getApellido());
            cbst.setString(4, prov.getDireccion());
            cbst.setString(5, prov.getTelefono());
            cbst.execute();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
      public boolean verificarDatos(String dato){
        ResultSet rs;
        try{
            CallableStatement call = cn.prepareCall("{call VerificarProveedor(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();
            return rs.next();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

   public void eliminar(String IdProveedor){
       
       try {
           CallableStatement cbst = cn.prepareCall("{call EliminarProveedor(?)}");
            cbst.setString(1, IdProveedor);
            cbst.executeUpdate();
            
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            
       
   }
   }
   

   
       public void actualizar(Proveedor prov){
           try {
               CallableStatement cbst = cn.prepareCall("{callModificarPro(?,?,?,?,?)}");
               cbst.setString(1, prov.getIdProveedor());
               cbst.setString(2, prov.getNombre());
               cbst.setString(3, prov.getApellido());
               cbst.setString(3, prov.getDireccion());
               cbst.setString(5, prov.getTelefono());
               
           }catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e);
                   
           } 
       }
   }
    
