
package kata_4;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Flo
 * Clase principal que demuestra polimorfismo con lista de animales
 * Upcasting, Polimorfismo, Sobrescritura de métodos
 */

public class MainAnimales {
    public static void main(String[] args) {
        
        // Crear lista de animales - UPCASTING implícito
        List<Animal> animales = new ArrayList<>();
        
        // .add animales de diferentes tipos a la Llist
        animales.add(new Perro("Chicho"));
        animales.add(new Gato("Mishi"));
        animales.add(new Vaca("Lola"));
        animales.add(new Perro("Budin"));
        animales.add(new Gato("Luna"));
        animales.add(new Vaca("Maca"));
        
        System.out.println("** DESCRIBIR ANIMALES **");
        // Mostrar descripción de todos los animales
        for (Animal animal : animales) {
            animal.describirAnimal(); // Método común no sobrescrito
        }
        
        System.out.println("\n** MOSTRAR SONIDOS CON POLIMORFISMO **");
        // muestra los sonidos de los animales con polimorfismo
        for (Animal animal : animales) {
            animal.hacerSonido(); // Llamada polimórfica - método sobrescrito
        }
        
    }
    
}
