
package Ejercicio_6;

public class Reserva {
    private String fecha;
    private String hora;
    private Cliente cliente;   //ASOCIACIÓN UNIDIRECCIONAL 
    private Mesa mesa;         //AGREGACIÓN 
    
    // Constructor
    public Reserva(String fecha, String hora, Cliente cliente, Mesa mesa) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente; // Asociación unidireccional
        this.mesa = mesa;       // Agregación
    }
    
    // Getters
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public Cliente getCliente() { return cliente; }
    public Mesa getMesa() { return mesa; }
    
    // Setter para AGREGACIÓN (mesa puede cambiarse)
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    // NO hay setter para Cliente (asociación unidireccional)
}
