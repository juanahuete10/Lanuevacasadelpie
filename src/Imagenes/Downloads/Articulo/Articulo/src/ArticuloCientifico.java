/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anleska obando
 */
public class ArticuloCientifico {

    String título;
    String autor; 
    String[] palabrasClaves = new String[3];
    String publicación; 
    int año; 
    String resumen; 
    
     public ArticuloCientifico(String título, String autor) {
        this.título = título;
        this.autor = autor;
       } 
     public ArticuloCientifico(String título, String autor, String[] palabrasClaves, String publicación, int año) {
      this(título, autor); 
      this.palabrasClaves = palabrasClaves;
      this.publicación = publicación;
      this.año = año;
    }
    public ArticuloCientifico(String título, String autor, String[] palabrasClaves, String publicación, int año, String resumen) {
     this(título, autor, palabrasClaves, publicación, año);
     this.resumen = resumen;
    }
  
public void imprimir(){
    System.out.println("Titulo del artículo=" + título);
    System.out.println("Autor del artículo=" + autor);
    System.out.println("Palabras clave=");
    
    for(int i =0; i<palabrasClaves.length;i++){
        System.out.println(palabrasClaves[i]);
    }
    System.out.println("Publicacion ="+ publicación);
    System.out.println("Año="+año);
    System.out.println("Resumen="+resumen);
}
}
  
 
