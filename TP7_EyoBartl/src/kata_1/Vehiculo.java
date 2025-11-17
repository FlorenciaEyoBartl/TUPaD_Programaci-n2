
package kata_1;

/**
 *
 * @author Flo
 */

// Clase base Vehículo 
public class Vehiculo {
    
    // atributos que va a heredar a otras clases
    private String marca;
    private String modelo;
    
    // método constructor que va a heredar a otras clases
    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    
     // método que va a heredar a otras clases
    public void mostrarInfo() {
        System.out.println("Marca: " + getMarca() + ", Modelo: " + getModelo());
    }

    
    public String getMarca() {
        return marca;
    }

   
    public void setMarca(String marca) {
        this.marca = marca;
    }

    
    public String getModelo() {
        return modelo;
    }

    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

