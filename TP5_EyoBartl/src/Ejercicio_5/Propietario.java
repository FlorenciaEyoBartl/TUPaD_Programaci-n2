
package Ejercicio_5;


public class Propietario {
    
    private String nombre;
    private String dni;
    private Computadora computadora; //Asociación bidireccional
    
    public Propietario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.computadora = null; //Inicialmente sin computadora
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public Computadora getComputadora() { return computadora; }
    
    // Setter para asociación bidireccional
    public void setComputadora(Computadora computadora) {
        this.computadora = computadora;
    }
    
}
