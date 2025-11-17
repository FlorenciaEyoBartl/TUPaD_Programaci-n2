
package kata_1;

/**
 * @author Flo
 * Subclase Auto que hereda de Vehículo
 */
public class Auto extends Vehiculo {
    private int cantidadPuertas;
    
    public Auto(String marca, String modelo, int cantidadPuertas) {
        super(marca, modelo); // Llama al método constructor de la superclase Vehiculo
        this.cantidadPuertas = cantidadPuertas;
    }
    
    @Override
    public void mostrarInfo() {
        // Llama al método de la superclase y añade información específica
        super.mostrarInfo();
        System.out.println("Cantidad de puertas: " + getCantidadPuertas());
    }
    
   
    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

   
    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }
}


