
package Ejercicio_7;


public class Conductor {
    private String nombre;
    private String licencia;
    private Vehiculo vehiculo; //Asociación bidireccional
    
    public Conductor(String nombre, String licencia) {
        this.nombre = nombre;
        this.licencia = licencia;
        this.vehiculo = null; // inicialmente sin vehículo
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public String getLicencia() { return licencia; }
    public Vehiculo getVehiculo() { return vehiculo; }
    
    // Setter para asociación bidireccional
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setLicencia(String licencia) { this.licencia = licencia; }
}
