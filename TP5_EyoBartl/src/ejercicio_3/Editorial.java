
package ejercicio_3;


public class Editorial {
    private String nombre;
    private String direccion;
    
    public Editorial(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
}
