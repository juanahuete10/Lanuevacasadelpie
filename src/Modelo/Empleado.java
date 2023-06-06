/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author personal
 */
public class Empleado extends Persona{
    String IdEmpleado;
  String Cargo;
 String IdPersona;

    public Empleado(String IdEmpleado, String Cargo, String IdPersona, String cedula, String nombre, String apellido, String direccion, String telefono) {
        super(cedula, nombre, apellido, direccion, telefono);
        this.IdEmpleado = IdEmpleado;
        this.Cargo = Cargo;
        this.IdPersona = IdPersona;
    }

    public Empleado(String IdEmpleado, String Cargo, String IdPersona) {
        this.IdEmpleado = IdEmpleado;
        this.Cargo = Cargo;
        this.IdPersona = IdPersona;
    }

    

    public Empleado() {
    }

    public Empleado(String text, String text0, String text1, String text2, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(String IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(String IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
 
}
 

    