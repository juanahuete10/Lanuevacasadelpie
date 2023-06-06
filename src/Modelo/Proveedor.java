/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author personal
 */
public class Proveedor extends Persona {
     String IdProveedor;
     String Email;
     String NombrEmpresa;
     String IdPersona;
     
        public Proveedor() {
    }
     
       public Proveedor(String IdProveedor, String Email, String NombrEmpresa, String IdPersona, String cedula, String nombre, String apellido, String direccion, String telefono) {
        super(cedula, nombre, apellido, direccion, telefono);
        this.IdProveedor = IdProveedor;
        this.Email = Email;
        this.NombrEmpresa = NombrEmpresa;
        this.IdPersona = IdPersona;
    }

    public Proveedor(String text, String text0, String text1, String text2, int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(String IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNombrEmpresa() {
        return NombrEmpresa;
    }

    public void setNombrEmpresa(String NombrEmpresa) {
        this.NombrEmpresa = NombrEmpresa;
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
