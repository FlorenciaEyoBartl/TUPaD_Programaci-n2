
package Ejercicio_8;


public class Usuario {
    private String nombre;
    private String email;
    
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    
}
