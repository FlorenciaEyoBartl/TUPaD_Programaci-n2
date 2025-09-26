
package Ejercicio_9;


public class Paciente {
    private String nombre;
    private String obraSocial;
    
    public Paciente(String nombre, String obraSocial) {
        this.nombre = nombre;
        this.obraSocial = obraSocial;
    }
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public String getObraSocial() { return obraSocial; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setObraSocial(String obraSocial) { this.obraSocial = obraSocial; }
}
