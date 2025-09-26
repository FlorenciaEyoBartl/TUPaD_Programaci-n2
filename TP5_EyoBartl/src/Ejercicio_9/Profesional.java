
package Ejercicio_9;

public class Profesional {
    private String nombre;
    private String especialidad;
    
    public Profesional(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}
