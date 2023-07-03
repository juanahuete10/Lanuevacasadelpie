/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package articulo;

/**
 *
 * @author Anleska obando
 */
public class Articulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String[] palabras = {"Física","Espacio","Tiempo"};
       
       Articulo artículo;
        artículo = new ArticuloCientifico ("Titulo","Autor",palabras,"publicacion",1913,"Resumen");
        System.out.println("La teoria de la relatividad");
        System.out.println("Abert Einsten");
        System.out.println("Fisica Espacio Tiempo");
        System.out.println("Anales de la fisica");
        System.out.println("1913");
        System.out.println("Las leyes de la fisica son las  mismas en todos los sistemas de referencia ");
    }

    
    
}
