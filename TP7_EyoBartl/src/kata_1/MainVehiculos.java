
package kata_1;

/**
 * @author Flo
 * Clase principal para probar la herencia de la clase Vehiculo
 */
public class MainVehiculos {
    public static void main(String[] args) {
        
        // Crea una instancia de Auto
        Auto miAuto = new Auto("Toyota", "Corolla", 4);
        
        System.out.println("*** Informacion del Auto ***");
        miAuto.mostrarInfo(); // Llama al método sobrescrito
        
        System.out.println("\n -- getters --");
        System.out.println("Marca: " + miAuto.getMarca());
        System.out.println("Modelo: " + miAuto.getModelo());
        System.out.println("Puertas: " + miAuto.getCantidadPuertas());
        
        System.out.println("\n -- setters --");
        miAuto.setMarca("Honda");
        miAuto.setModelo("Civic");
        miAuto.setCantidadPuertas(2);
        miAuto.mostrarInfo();
        
        // Demostración de upcasting
        System.out.println("\n*** Upcasting ***");
        Vehiculo vehiculo = miAuto; // Upcasting implícito
        vehiculo.mostrarInfo(); // Still llama al método de Auto (polimorfismo)
    }
}