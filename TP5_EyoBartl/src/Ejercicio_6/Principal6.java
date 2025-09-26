//Para correr cada clase principal precione click derecho y luego "Run File"
package Ejercicio_6;

public class Principal6 {
    public static void main(String[] args) {
        System.out.println("EJERCICIO 6");
        
        //Crear Cliente (asociación unidireccional)
        Cliente cliente = new Cliente("Laura Martínez", "555-1234");
        
        //Crear Mesa (agregación)
        Mesa mesa = new Mesa(5, 4);
        
        //Crear Reserva con Cliente y Mesa
        Reserva reserva = new Reserva("2024-01-15", "20:00", cliente, mesa);
        
        //relaciones
        System.out.println("Reserva: " + reserva.getFecha() + " a las " + reserva.getHora());
        System.out.println("Cliente: " + reserva.getCliente().getNombre());
        System.out.println("Teléfono: " + reserva.getCliente().getTelefono());
        System.out.println("Mesa: " + reserva.getMesa().getNumero() + 
                         " (Capacidad: " + reserva.getMesa().getCapacidad() + " personas)");
        
        // ASOCIACIÓN UNIDIRECCIONAL
        // El cliente NO sabe sobre la reserva (solo la reserva conoce al cliente)
        // no tiene método getReserva()
        
        //AGREGACIÓN (cambiar mesa)
        Mesa nuevaMesa = new Mesa(8, 6);
        reserva.setMesa(nuevaMesa);
        System.out.println("Nueva mesa: " + reserva.getMesa().getNumero());
        
      
        
    }
}
