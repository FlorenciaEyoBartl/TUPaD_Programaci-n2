
package ejercicio_1;

public class Titular {
    // Atributos
    private String nombre;
    private String dni;
    private Pasaporte pasaporte; // ← REFERENCIA BIDIRECCIONAL
    
    // Constructor
    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public Pasaporte getPasaporte() { return pasaporte; }
    
    public void setPasaporte(Pasaporte pasaporte) {
        this.pasaporte = pasaporte;
    }
}
