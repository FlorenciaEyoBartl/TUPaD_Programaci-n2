
package Ejercicio_5;


public class Computadora {
    
    private String marca;
    private String numeroSerie;
    private PlacaMadre placaMadre;   // COMPOSICIÓN
    private Propietario propietario; // ASOCIACIÓN BIDIRECCIONAL 
    
    //Constructor aca se da la COMPOSICIÓN
    public Computadora(String marca, String numeroSerie, 
                      String modeloPlaca, String chipsetPlaca) {
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        //COMPOSICIÓN la placa madre se crea DENTRO de la computadora
        this.placaMadre = new PlacaMadre(modeloPlaca, chipsetPlaca);
        this.propietario = null; //Inicialmente sin propietario
    }
    
    // Getters
    public String getMarca() { return marca; }
    public String getNumeroSerie() { return numeroSerie; }
    public PlacaMadre getPlacaMadre() { return placaMadre; }
    public Propietario getPropietario() { return propietario; }
    
    //Setter para asociación bidireccional
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
        //BIDIRECCIONALIDAD el propietario también conoce esta computadora
        if (propietario != null) {
            propietario.setComputadora(this);
        }
    }
    
}
