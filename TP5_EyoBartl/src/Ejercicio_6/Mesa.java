
package Ejercicio_6;


public class Mesa {
    private int numero;
    private int capacidad;
    
    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }
    
    // Getters y setters
    public int getNumero() { return numero; }
    public int getCapacidad() { return capacidad; }
    public void setNumero(int numero) { this.numero = numero; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
}

