package Modelo;

public class Garantia {

    /* nombreGarantia varchar(60),
 descripcionGarantia varchar(200),
 estadoPrenda varchar(20))*/
    int codGarantia;
    String nombreGarantia;
    String descripcionGarantia;
    String estadoPrenda;
    
    public Garantia(int codGarantia, String nombreGarantia) {
        this.codGarantia = codGarantia;
        this.nombreGarantia = nombreGarantia;
    }
    
    public Garantia(int codGarantia, String nombreGarantia, String descripcionGarantia, String estadoPrenda) {
        this.codGarantia = codGarantia;
        this.nombreGarantia = nombreGarantia;
        this.descripcionGarantia = descripcionGarantia;
        this.estadoPrenda = estadoPrenda;
    }

    public Garantia() {
    }
    
  


    public int getCodGarantia() {
        return codGarantia;
    }

    public void setCodGarantia(int codGarantia) {
        this.codGarantia = codGarantia;
    }

    public String getNombreGarantia() {
        return nombreGarantia;
    }

    public void setNombreGarantia(String nombreGarantia) {
        this.nombreGarantia = nombreGarantia;
    }

    public String getDescripcionGarantia() {
        return descripcionGarantia;
    }

    public void setDescripcionGarantia(String descripcionGarantia) {
        this.descripcionGarantia = descripcionGarantia;
    }

    public String getEstadoPrenda() {
        return estadoPrenda;
    }

    public void setEstadoPrenda(String estadoPrenda) {
        this.estadoPrenda = estadoPrenda;
    }
    @Override
    public String toString(){
        return codGarantia +" - " + nombreGarantia;
    }

   
}
