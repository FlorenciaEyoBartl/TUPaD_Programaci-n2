package ecommerce;

/**
 *
 * @author Flo
 */
public class TarjetaCredito implements PagoConDescuento {
    private String numeroTarjeta;
    private String titular;
    
    public TarjetaCredito(String numeroTarjeta, String titular) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
    }
    
    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago de $" + monto + " con tarjeta de credito");
        System.out.println("Tarjeta: " + numeroTarjeta + " - Titular: " + titular);
    }
    
    @Override
    public void aplicarDescuento(double porcentaje) {
        System.out.println("Aplicando descuento del " + porcentaje + "% pagando con tarjeta de credito");
    }
}

