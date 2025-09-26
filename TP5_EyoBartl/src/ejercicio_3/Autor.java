
package ejercicio_3;


public class Autor {
    private String nombre;
    private String nacionalidad;
    
    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
    
}
