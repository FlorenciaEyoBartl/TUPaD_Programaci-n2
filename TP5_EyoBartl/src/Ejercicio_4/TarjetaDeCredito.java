
package Ejercicio_4;

public class TarjetaDeCredito {
        private String numero;
    private String fechaVencimiento;
    private Cliente cliente;   //ASOCIACIÓN BIDIRECCIONAL
    private Banco banco;       //AGREGACIÓN
    
    // Constructor con banco (agregación)
    public TarjetaDeCredito(String numero, String fechaVencimiento, Banco banco) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.banco = banco;    // Agregación
        this.cliente = null;   // Inicialmente sin cliente
        
        // Establecer relación inversa con banco
        if (banco != null) {
            banco.setTarjeta(this);
        }
    }
    
    // Getters
    public String getNumero() { return numero; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public Cliente getCliente() { return cliente; }
    public Banco getBanco() { return banco; }
    
    // Setter para asociación bidireccional
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    // Setter para agregación (banco puede cambiarse)
    public void setBanco(Banco banco) {
        this.banco = banco;
        if (banco != null) {
            banco.setTarjeta(this);
        }
    }
}
