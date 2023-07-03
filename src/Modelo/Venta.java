/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author personal
 */
public class Venta {
    int CodigoVenta;
    int IdCliente;
    int IdEmpleado;
     int Fecha;

    public Venta(int IdCliente, int IdEmpleado, int Fecha) {
        this.IdCliente = IdCliente;
        this.IdEmpleado = IdEmpleado;
        this.Fecha = Fecha;
    }
     
     
     
      public Venta(int CodigoVenta, int IdCliente, int IdEmpleado, int Fecha) {
        this.CodigoVenta = CodigoVenta;
        this.IdCliente = IdCliente;
        this.IdEmpleado = IdEmpleado;
        this.Fecha = Fecha;
    }

    public Venta() {
    }

    public int getCodigoVenta() {
        return CodigoVenta;
    }

    public void setCodigoVenta(int CodigoVenta) {
        this.CodigoVenta = CodigoVenta;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public int getFecha() {
        return Fecha;
    }

    public void setFecha(int Fecha) {
        this.Fecha = Fecha;
    }

   
     
    
   
}
