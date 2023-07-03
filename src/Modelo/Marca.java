/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author personal
 */
public class Marca {
    int IdMarca;
    String NombreMarca;

    public Marca(String NombreMarca) {
        this.NombreMarca = NombreMarca;
    }
    

    public Marca() {
    }
    
    public Marca(int IdMarca, String NombreMarca) {
        this.IdMarca = IdMarca;
        this.NombreMarca = NombreMarca;
    }

    public int getIdMarca() {
        return IdMarca;
    }

    public void setIdMarca(int IdMarca) {
        this.IdMarca = IdMarca;
    }

    public String getNombreMarca() {
        return NombreMarca;
    }

    public void setNombreMarca(String NombreMarca) {
        this.NombreMarca = NombreMarca;
    }

   
     @Override
  public String toString(){
      return IdMarca + " - " + NombreMarca;
  }
    
}
