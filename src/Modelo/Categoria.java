
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author personal
 */
public class Categoria {
     String IdCategorias;
     String Nombre;
     String Descripcion;
     
       public Categoria() {
    }

    public Categoria(String IdCategorias, String Nombre, String Descripcion) {
        this.IdCategorias = IdCategorias;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }
    

    public String getIdCategorias() {
        return IdCategorias;
    }

    public void setIdCategorias(String IdCategorias) {
        this.IdCategorias = IdCategorias;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
     
     
}

    
    

   