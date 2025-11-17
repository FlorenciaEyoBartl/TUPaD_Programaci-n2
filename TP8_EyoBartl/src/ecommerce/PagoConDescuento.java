package ecommerce;

/**
 *
 * @author Flo
 */
public interface PagoConDescuento extends Pago {
    void aplicarDescuento(double porcentaje);
}