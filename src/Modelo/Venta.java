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
    String NommbreCliente;
     int Fecha;

    public Venta() {
    }

    public Venta(int CodigoVenta, String NommbreCliente, int Fecha) {
        this.CodigoVenta = CodigoVenta;
        this.NommbreCliente = NommbreCliente;
        this.Fecha = Fecha;
    }

    public int getCodigoVenta() {
        return CodigoVenta;
    }

    public void setCodigoVenta(int CodigoVenta) {
        this.CodigoVenta = CodigoVenta;
    }

    public String getNommbreCliente() {
        return NommbreCliente;
    }

    public void setNommbreCliente(String NommbreCliente) {
        this.NommbreCliente = NommbreCliente;
    }

    public int getFecha() {
        return Fecha;
    }

    public void setFecha(int Fecha) {
        this.Fecha = Fecha;
    }
    
}
