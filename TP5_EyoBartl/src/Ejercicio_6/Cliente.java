
package Ejercicio_6;


public class Cliente {
    private String nombre;
    private String telefono;
    
    public Cliente(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", telefono=" + telefono + '}';
    }
    
    
}
