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
    int IdProducto;
    int PrecioVenta;
    int CantidadDisponible;
    int PrecioCompra;
    String Descripcion;
    int IdCategorias;
    String Talla;
    String Proveedor;
    int IdMarca;
    String Marca;
    
    public Producto() {
    }

    public Producto(int PrecioVenta, int CantidadDisponible, int PrecioCompra, String Descripcion, String Talla) {
        this.PrecioVenta = PrecioVenta;
        this.CantidadDisponible = CantidadDisponible;
        this.PrecioCompra = PrecioCompra;
        this.Descripcion = Descripcion;
        this.Talla = Talla;
    }

    
    
    public Producto(int IdProducto, int PrecioVenta, int CantidadDisponible, int PrecioCompra, String Descripcion, int IdCategorias, String Talla, String Proveedor, int IdMarca, String Marca) {
        this.IdProducto = IdProducto;
        this.PrecioVenta = PrecioVenta;
        this.CantidadDisponible = CantidadDisponible;
        this.PrecioCompra = PrecioCompra;
        this.Descripcion = Descripcion;
        this.IdCategorias = IdCategorias;
        this.Talla = Talla;
        this.Proveedor = Proveedor;
        this.IdMarca = IdMarca;
        this.Marca = Marca;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }
    
    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
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

    public int getIdCategorias() {
        return IdCategorias;
    }

    public void setIdCategorias(int IdCategorias) {
        this.IdCategorias = IdCategorias;
    }

    public String getTalla() {
        return Talla;
    }

    public void setTalla(String Talla) {
        this.Talla = Talla;
    }

    public int getIdMarca() {
        return IdMarca;
    }

    public void setIdMarca(int IdMarca) {
        this.IdMarca = IdMarca;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }



}
