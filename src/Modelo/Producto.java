/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author personal
 */
public class Producto {
     String IdProducto;
    int PrecioVenta;
    int CantidadDisponible;
     int PrecioCompra;
     String Descripcion;
     String Categoria;
     String Talla;
     
     public Producto() {
    }
     
     public Producto(String IdProducto, int PrecioVenta, int CantidadDisponible, int PrecioCompra, String Descripcion, String Categoria, String Talla) {
        this.IdProducto = IdProducto;
        this.PrecioVenta = PrecioVenta;
        this.CantidadDisponible = CantidadDisponible;
        this.PrecioCompra = PrecioCompra;
        this.Descripcion = Descripcion;
        this.Categoria = Categoria;
        this.Talla = Talla;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(int PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public int getCantidadDisponible() {
        return CantidadDisponible;
    }

    public void setCantidadDisponible(int CantidadDisponible) {
        this.CantidadDisponible = CantidadDisponible;
    }

    public int getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(int PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getTalla() {
        return Talla;
    }

    public void setTalla(String Talla) {
        this.Talla = Talla;
    }

    

    
 
     
}