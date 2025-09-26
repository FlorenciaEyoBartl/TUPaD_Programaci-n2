
package Ejercicio_4;


public class Cliente {
    private String nombre;
    private String dni;
    private TarjetaDeCredito tarjeta; // Asociación bidireccional
    
    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.tarjeta = null; // Inicialmente sin tarjeta
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public TarjetaDeCredito getTarjeta() { return tarjeta; }
    
    // Setter para asociación bidireccional
    public void setTarjeta(TarjetaDeCredito tarjeta) {
        this.tarjeta = tarjeta;
        if (tarjeta != null) {
            tarjeta.setCliente(this); // bidireccionalidad
        }
    }
}
