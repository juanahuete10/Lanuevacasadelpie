/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Marca;
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
public class CRUDMarca {
    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
    
    public ArrayList mostrarDatosCombo() {

        ArrayList<Marca> Marcas = new ArrayList();

        try {
            CallableStatement cbstc = cn.prepareCall("{call RellenarMarca}");
            ResultSet rs = cbstc.executeQuery();
            while (rs.next()) {
                Marca ma = new Marca();
                ma.setIdMarca(Integer.parseInt(rs.getString("IdMarca")));
                ma.setNombreMarca(rs.getString("NombreMarca"));
                Marcas.add(ma);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Marcas;
    }
    
    public DefaultTableModel mostrarDatos(){
        ResultSet rs;
       DefaultTableModel modelo;
       String[] titulos = {"IdMarca", "NombreMarca"};
       String[] registro = new String[2];
       
       modelo = new DefaultTableModel(null, titulos);
       
       try {
           CallableStatement cbstc = cn.prepareCall("{call MostrarMarcas}");
            rs = cbstc.executeQuery();
            
            while (rs.next()) {
                registro[0] = rs.getString("IdMarca");
                   registro[1] = rs.getNString("NombreMarca");
                  
                   
                   modelo.addRow(registro);
            }
            return modelo;
       }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
           return null;
    }
}
    
     public void Agregar (Marca ma){
        
        try {
            CallableStatement cbst = cn.prepareCall("{call InsertarMarca(?)}");
            cbst.setString(1, ma.getNombreMarca());
            cbst.execute();
            
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        }
     
      public boolean verificarDatos(String dato){
        ResultSet rs;
        try{
            CallableStatement call = cn.prepareCall("{call VerificarMarca(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();
            return rs.next();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
      
      public void eliminar(String IdMarca){
         
          try{
               CallableStatement cbst = cn.prepareCall("{call Eliminar_Marcas(?)}");
            cbst.setString(1, IdMarca);
            cbst.executeUpdate();
            
          }catch (SQLException e) {
               JOptionPane.showMessageDialog(null, e);
          }
     }
      
      public void actualizar(Marca ma){
            try{
                CallableStatement cbst = cn.prepareCall("{call ActualizarMarca(?)}");
                cbst.setString(1, ma.getNombreMarca());
                cbst.executeUpdate();
                
            }catch (SQLException e){
              JOptionPane.showMessageDialog(null, e);  
            }
            
        }
}
