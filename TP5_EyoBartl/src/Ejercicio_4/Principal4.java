//Para correr cada clase principal precione click derecho y luego "Run File"
package Ejercicio_4;


public class Principal4 {
     public static void main(String[] args) {
        System.out.println("EJERCICIO 4");
        
        //Crear Banco
        Banco banco = new Banco("Banco Nación", "30-12345678-9");
        
        // Crear Cliente
        Cliente cliente = new Cliente("María Rodríguez", "35123456");
        
        //Crear Tarjeta con el banco (agregación)
        TarjetaDeCredito tarjeta = new TarjetaDeCredito("1234567812345678", "12/25", banco);
        
        //Establecer asociación bidireccional
        cliente.setTarjeta(tarjeta);
        
        //relaciones
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Tarjeta: " + cliente.getTarjeta().getNumero());
        System.out.println("Banco: " + cliente.getTarjeta().getBanco().getNombre());
        System.out.println("Vencimiento: " + cliente.getTarjeta().getFechaVencimiento());
        
        // bidireccionalidad
        System.out.println("¿Coinciden referencias de tarjeta y cliente? " + 
                          (cliente.getTarjeta().getCliente() == cliente)); // true
        
        // agregación (opción cambiar banco)
        Banco nuevoBanco = new Banco("Banco Provincia", "30-87654321-1");
        tarjeta.setBanco(nuevoBanco);
        System.out.println("Nuevo banco: " + tarjeta.getBanco().getNombre());
        
        
    }
}
