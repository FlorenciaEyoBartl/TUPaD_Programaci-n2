package ecommerce;

/**
 *
 * @author Flo
 */
public class PayPal implements Pago {
    private String email;
    
    public PayPal(String email) {
        this.email = email;
    }
    
    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago de $" + monto + " con PayPal");
        System.out.println("Email: " + email);
    }
}

