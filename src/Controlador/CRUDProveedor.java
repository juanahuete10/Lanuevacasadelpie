/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Proveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author personal
 */
public class CRUDProveedor {
     private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
    
    public ArrayList mostrarDatosCombo() {

        ArrayList<Proveedor> Proveedor = new ArrayList();

        try {
            CallableStatement cbstc = cn.prepareCall("{call RellenarProveedores}");
            ResultSet rs = cbstc.executeQuery();
            while (rs.next()) {
                Proveedor pro = new Proveedor();
                pro.setIdProveedor(Integer.parseInt(rs.getString("IdProveedor")));
                pro.setNombrEmpresa(rs.getString("NombrEmpresa"));
                Proveedor.add(pro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Proveedor;
    }
    
    public DefaultTableModel mostrarDatos(){
        ResultSet rs;
       DefaultTableModel modelo;
       String[] titulos = {"IdProveedor", "Email", "NombrEmpresa", "Cedula","Nombre", "Apellido", "Direccion", "Telefono"};
       String[] registro = new String[8];
       
       modelo = new DefaultTableModel(null, titulos);
       
       try{
           CallableStatement cbstc = cn.prepareCall("{call MostrarProveedores}");
            rs = cbstc.executeQuery();
            
             while (rs.next()) {
                 registro[0] = rs.getString("IdProveedor");
                 registro[1] = rs.getNString("Email");
                 registro[2] = rs.getNString("NombrEmpresa");
                 registro[3] = rs.getNString("Cedula");
                   registro[4] = rs.getNString("Nombre");
                   registro[5] = rs.getNString("Apellido");
                   registro[6] = rs.getNString("Direccion");
                   registro[7] = rs.getString("Telefono");
                   
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
            CallableStatement cbst = cn.prepareCall("{call InsertarProveedor(?,?,?,?,?,?,?)}");
            cbst.setString(1, prov.getEmail());
            cbst.setString(2, prov.getNombrEmpresa());
            cbst.setString(3, prov.getCedula());
            cbst.setString(4, prov.getNombre());
            cbst.setString(5, prov.getApellido());
            cbst.setString(6, prov.getDireccion());
            cbst.setString(7, prov.getTelefono());
            cbst.execute();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
      public boolean verificarDatos(String dato){
        ResultSet rs;
        try{
            CallableStatement call = cn.prepareCall("{call VerificarProveedores(?)}");
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
           CallableStatement cbst = cn.prepareCall("{call Eliminar_Proveedores(?)}");
            cbst.setString(1, IdProveedor);
            cbst.executeUpdate();
            
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            
       
   }
   }
   
             public void actualizar(Proveedor prov){
           try {
               CallableStatement cbst = cn.prepareCall("{call ActualizarProveedores(?,?,?,?,?,?,?)}");
               cbst.setString(1, prov.getEmail());
               cbst.setString(2, prov.getNombrEmpresa());
               cbst.setString(3, prov.getCedula());
               cbst.setString(4, prov.getNombre());
               cbst.setString(5, prov.getApellido());
               cbst.setString(6, prov.getDireccion());
               cbst.setString(7, prov.getTelefono());
               
           }catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e);
                   
           } 
       }
}
