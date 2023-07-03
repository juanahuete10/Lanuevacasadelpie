package Controlador;

import Modelo.Cliente;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CRUDCliente {

    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();

    public DefaultTableModel mostrarDatos() {
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"Cédula", "Nombres", "Apellidos", "Sobrenombre", "Telefono", "Dirección"};
        String[] registro = new String[6];

        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement cbstc = cn.prepareCall("{call MostrarClientes}");
            rs = cbstc.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("cedula");
                registro[1] = rs.getString("nombres");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("sobrenombre");
                registro[4] = rs.getString("telefono");
                registro[5] = rs.getString("direccion");

                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public DefaultTableModel buscarDatos(String dato) {
        ResultSet rs;
        DefaultTableModel modelo;

        String[] titulos = {"Cédula", "Nombres", "Apellidos", "Sobrenombre", "Telefono", "Dirección"};
        String[] registro = new String[6];

        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call ConsultarClientes(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("cedula");
                registro[1] = rs.getString("nombres");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("sobrenombre");
                registro[4] = rs.getString("telefono");
                registro[5] = rs.getString("direccion");

                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public boolean verificarDatos(String dato) {
        ResultSet rs;

        try {
            CallableStatement call = cn.prepareCall("{call ConsultarClientes(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public void Guardar(Cliente cl) {
        try {
            CallableStatement cbst = cn.prepareCall("{call CrearCliente(?,?,?,?,?,?)}");
            cbst.setString(1, cl.getCedula());
            cbst.setString(2, cl.getNombres());
            cbst.setString(3, cl.getApellidos());
            cbst.setString(4, cl.getSobrenombre());
            cbst.setString(5, cl.getTelefono());
            cbst.setString(6, cl.getDireccion());
            cbst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void actualizar(Cliente cl) {
        try {
            CallableStatement cbst = cn.prepareCall("{call ModificarCliente(?,?,?,?,?,?)}");
            cbst.setString(1, cl.getCedula());
            cbst.setString(2, cl.getNombres());
            cbst.setString(3, cl.getApellidos());
            cbst.setString(4, cl.getSobrenombre());
            cbst.setString(5, cl.getTelefono());
            cbst.setString(6, cl.getDireccion());
            cbst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void eliminar(String cedula) {
        try {
            CallableStatement cbst = cn.prepareCall("{call EliminarClientes(?)}");
            cbst.setString(1, cedula);
            cbst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
