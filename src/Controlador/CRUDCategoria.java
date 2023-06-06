/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Categoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author personal
 */
public class CRUDCategoria {
    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
    
    public DefaultTableModel mostrarDatos(){
        ResultSet rs;
       DefaultTableModel modelo;
       String[] titulos = {"IdCategorias", "Nombre", "Descripcion"};
       String[] registro = new String[3];
       
       modelo = new DefaultTableModel(null, titulos);
       
       try {
           CallableStatement cbstc = cn.prepareCall("{call MostrarCategorias}");
            rs = cbstc.executeQuery();
            
            while (rs.next()) {
                registro[0] = rs.getString("IdCategorias");
                   registro[1] = rs.getNString("Nombre");
                   registro[2] = rs.getNString("Descripcion");
                   
                   modelo.addRow(registro);
            }
            return modelo;
       }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
           return null;
    }
}
    public void Agregar (Categoria ca){
        
        try {
            CallableStatement cbst = cn.prepareCall("{call InsertarCategorias(?,?,?)}");
            cbst.setString(1, ca.getIdCategorias());
            cbst.setString(2, ca.getNombre());
            cbst.setString(3, ca.getDescripcion());
            cbst.execute();
            
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        }
    
    public boolean verificarDatos(String dato){
        ResultSet rs;
        try{
            CallableStatement call = cn.prepareCall("{call VerificarCategorias(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();
            return rs.next();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    
     public void eliminar(String IdCategorias){
         
          try{
               CallableStatement cbst = cn.prepareCall("{call Eliminar_Categorias(?)}");
            cbst.setString(1, IdCategorias);
            cbst.executeUpdate();
            
          }catch (SQLException e) {
               JOptionPane.showMessageDialog(null, e);
          }
     }
             
        public void actualizar(Categoria ca){
            try{
                CallableStatement cbst = cn.prepareCall("{call ActualizarCategorias(?,?,?,?,?,?,?)}");
                cbst.setInt(ca.getIdCategorias(), 1);
                cbst.setString(2, ca.getNombre());
                cbst.setString(3, ca.getDescripcion());
                
            }catch (SQLException e){
              JOptionPane.showMessageDialog(null, e);  
            }
            
        }
    }
