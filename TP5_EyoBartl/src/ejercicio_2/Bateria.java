
package ejercicio_2;


public class Bateria {
    
    private String modelo;
    private String capacidad;
    
    public Bateria(String modelo, String capacidad) {
        this.modelo = modelo;
        this.capacidad = capacidad;
    }
    
    // Getters
    public String getModelo() { return modelo; }
    public String getCapacidad() { return capacidad; }
    
    // Setters (importantes en agregación)
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setCapacidad(String capacidad) { this.capacidad = capacidad; }
    
  
}
