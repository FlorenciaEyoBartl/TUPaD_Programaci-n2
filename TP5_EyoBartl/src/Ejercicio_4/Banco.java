
package Ejercicio_4;


public class Banco {
    
    private String nombre;
    private String cuit;
    private TarjetaDeCredito tarjeta; // Agregación
    
    public Banco(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.tarjeta = null; // Inicialmente sin tarjeta
    }
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public String getCuit() { return cuit; }
    public TarjetaDeCredito getTarjeta() { return tarjeta; }
    
    public void setTarjeta(TarjetaDeCredito tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCuit(String cuit) { this.cuit = cuit; }
    
}
