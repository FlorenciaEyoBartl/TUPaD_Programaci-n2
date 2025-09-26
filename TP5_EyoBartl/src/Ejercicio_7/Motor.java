
package Ejercicio_7;


public class Motor {
    private String tipo;
    private String numeroSerie;
    private Vehiculo vehiculo; //Agregación
    
    public Motor(String tipo, String numeroSerie) {
        this.tipo = tipo;
        this.numeroSerie = numeroSerie;
        this.vehiculo = null; // Inicialmente sin vehículo
    }
    
    // Getters y setters
    public String getTipo() { return tipo; }
    public String getNumeroSerie() { return numeroSerie; }
    public Vehiculo getVehiculo() { return vehiculo; }
    
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
}
