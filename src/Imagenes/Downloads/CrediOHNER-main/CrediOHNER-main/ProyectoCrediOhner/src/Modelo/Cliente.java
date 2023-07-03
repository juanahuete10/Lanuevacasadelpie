/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Cliente extends Persona {
    
    String sobrenombre;

   
    public Cliente(String cedula, String nombres, String apellidos,String sobrenombre, 
            String telefono, String direccion) {
        super(cedula, nombres, apellidos, telefono, direccion);
        this.sobrenombre=sobrenombre;
    }
    
    public Cliente(){
        
    }


    public String getSobrenombre() {
        return sobrenombre;
    }

    public void setSobrenombre(String sobrenombre) {
        this.sobrenombre = sobrenombre;
    }
    
   
    
}
