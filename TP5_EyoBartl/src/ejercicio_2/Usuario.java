
package ejercicio_2;


public class Usuario {
    
    private String nombre;
    private String dni;
    private Celular celular; // Referencia bidireccional
    
    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public Celular getCelular() { return celular; }
    
    public void setCelular(Celular celular) {
        this.celular = celular;
    }
    
}
