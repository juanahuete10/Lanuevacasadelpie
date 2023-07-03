/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Garantia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class CRUDGarantia {

    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();

    public ArrayList mostrarDatosCombo() {

        ArrayList<Garantia> Garantias = new ArrayList();

        try {
            CallableStatement cbstc = cn.prepareCall("{call MostrarGarantias}");
            ResultSet rs = cbstc.executeQuery();
            while (rs.next()) {
                Garantia gr = new Garantia();
                gr.setCodGarantia(Integer.parseInt(rs.getString("codGarantia")));
                gr.setNombreGarantia(rs.getString("nombreGarantia"));
                Garantias.add(gr);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Garantias;
    }

    public DefaultTableModel mostrarDatos() {
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"Código", "Descripción", "Observación", "Estado"};
        String[] registro = new String[4];

        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement cbstc = cn.prepareCall("{call MostrarGarantias}");
            rs = cbstc.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("codGarantia");
                registro[1] = rs.getString("nombreGarantia");
                registro[2] = rs.getString("descripcionGarantia");
                registro[3] = rs.getString("estadoPrenda");

                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public DefaultTableModel MostrarDatos(String dato) {
        ResultSet rs;
        DefaultTableModel modelo;

        String[] titulos = {"Código", "Descripción", "Observación", "Estado"};
        String[] registro = new String[4];

        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call ConsultarGarantias(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("codGarantia");
                registro[1] = rs.getString("nombreGarantia");
                registro[2] = rs.getString("descripcionGarantia");
                registro[3] = rs.getString("estadoPrenda");

                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public boolean verificarDatos(String dato) {
        ResultSet rs;

        try {
            CallableStatement call = cn.prepareCall("{call ConsultarGarantias(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public void Guardar(Garantia gr) {
        try {
            CallableStatement cbst = cn.prepareCall("{call CrearGarantia(?,?,?)}");
            cbst.setString(1, gr.getNombreGarantia());
            cbst.setString(2, gr.getDescripcionGarantia());
            cbst.setString(3, gr.getEstadoPrenda());
            cbst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public boolean actualizar(Garantia gr) {
        try {
            CallableStatement cbst = cn.prepareCall("{call ModificarGarantia(?,?,?,?)}");
            cbst.setInt(1, gr.getCodGarantia());
            cbst.setString(2, gr.getNombreGarantia());
            cbst.setString(3, gr.getDescripcionGarantia());
            cbst.setString(4, gr.getEstadoPrenda());
            return cbst.executeUpdate() > -1;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public void eliminar(int cod) {
        try {
            CallableStatement cbst = cn.prepareCall("{call EliminarGarantias(?)}");
            cbst.setInt(1, cod);
            cbst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
