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
     int IdProveedor;
     String Email;
     String NombrEmpresa;
     int IdPersona;

    public Proveedor() {
    }
   

    public Proveedor(int IdProveedor, String NombrEmpresa) {
        this.IdProveedor = IdProveedor;
        this.NombrEmpresa = NombrEmpresa;
    }

    public Proveedor(String Email, String NombrEmpresa, String cedula, String nombre, String apellido, String direccion, String telefono) {
        super(cedula, nombre, apellido, direccion, telefono);
        this.Email = Email;
        this.NombrEmpresa = NombrEmpresa;
    }
    
    public Proveedor(int IdProveedor, String Email, String NombrEmpresa, String cedula, String nombre, String apellido, String direccion, String telefono) {
        super(cedula, nombre, apellido, direccion, telefono);
        this.IdProveedor = IdProveedor;
        this.Email = Email;
        this.NombrEmpresa = NombrEmpresa;
        
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
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

    public int getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(int IdPersona) {
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

     @Override
    public String toString(){
        return IdProveedor +" - " + NombrEmpresa;
    }
    
}
