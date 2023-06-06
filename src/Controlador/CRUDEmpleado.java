/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Empleado;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author personal
 */
public class CRUDEmpleado {
    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
    
    public DefaultTableModel mostrarDatos(){
        ResultSet rs;
       DefaultTableModel modelo;
       String[] titulos = {"IdEmpleado", "Cedula", "Nombre", "Apellido", "Direccion", "Telefono", "Cargo"};
       String[] registro = new String[7];
       
       modelo = new DefaultTableModel(null, titulos);
               
       try{
            CallableStatement cbstc = cn.prepareCall("{call MostrarEmpleado}");
            rs = cbstc.executeQuery();
           
            while (rs.next()) {
                registro[0] = rs.getString("IdEmpleado");
                   registro[1] = rs.getNString("Cedula");
                   registro[2] = rs.getNString("Nombre");
                   registro[3] = rs.getNString("Apellido");
                   registro[4] = rs.getNString("Direccion");
                   registro[5] = rs.getString("Telefono");
                   registro[6] = rs.getNString("Cargo");
                   
                   modelo.addRow(registro);
            }
            return modelo;
            
       }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
           return null;
       }
    }
    public void Agregar (Empleado emp){
        try{
            CallableStatement cbst = cn.prepareCall("{call InsertarEmpleado(?,?,?,?,?,?,?)}");
            cbst.setString(1, emp.getIdEmpleado());
            cbst.setString(2, emp.getCedula());
            cbst.setString(3, emp.getNombre());
            cbst.setString(4, emp.getApellido());
            cbst.setString(5, emp.getDireccion());
            cbst.setString(6, emp.getTelefono());
            cbst.setString(7, emp.getCargo());
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public boolean verificarDatos(String dato){
        ResultSet rs;
        try{
            CallableStatement call = cn.prepareCall("{call VerificarEmpleado(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();
            return rs.next();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
     public void eliminar(String IdEmpleado){
         
          try{
               CallableStatement cbst = cn.prepareCall("{call Eliminar Empleado(?)}");
            cbst.setString(1, IdEmpleado);
            cbst.executeUpdate();
            
          }catch (SQLException e) {
               JOptionPane.showMessageDialog(null, e);
          }
     }
    
    public void actualizar(Empleado emp){
        try{
            CallableStatement cbst = cn.prepareCall("{call ACtualizarEmpleado(?,?,?,?,?,?,?)}");
            cbst.setString(1, emp.getIdEmpleado());
             cbst.setString(2, emp.getCedula());
            cbst.setString(3, emp.getNombre());
            cbst.setString(4, emp.getApellido());
            cbst.setString(5, emp.getDireccion());
              cbst.setString(6, emp.getTelefono());
            cbst.setString(7, emp.getCargo());
                    
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        
        }
    }
}
