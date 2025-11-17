package ecommerce;

/**
 *
 * @author Flo
 */
public class MainEcommerce {
    
    public static void main(String[] args) {
     
        System.out.println("*** SISTEMA E-COMMERCE ***");
        
        // Crear cliente
        Cliente cliente = new Cliente("Juan Perez", "juan@email.com");
        
        // Crear productos
        Producto producto1 = new Producto("Laptop", 1500.0);
        Producto producto2 = new Producto("Mouse", 25.0);
        
        // Crear pedido
        Pedido pedido = new Pedido(cliente);
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);
        
        // Calcular total
        System.out.println("Total del pedido: $" + pedido.calcularTotal());
        
        // Probar cambio de estado con notificación
        pedido.cambiarEstado("EN PROCESO");
        pedido.cambiarEstado("ENVIADO");
        
        // Probar medios de pago
        TarjetaCredito tarjeta = new TarjetaCredito("1234-5678-9012-3456", "Juan Perez");
        tarjeta.aplicarDescuento(10);
        tarjeta.procesarPago(pedido.calcularTotal());
        
        PayPal paypal = new PayPal("juan@email.com");
        paypal.procesarPago(100.0);
        
      
        System.out.println("\n-- MANEJO DE EXCEPCIONES --");
        
        // Probar división segura
        System.out.println("Division 10/2: " + DivisionSegura.dividir(10, 2));
        
        // Probar validación de edad
        try {
            ValidadorEdad.validarEdad(25);
            System.out.println("Edad Valida");
        } catch (EdadInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }
}