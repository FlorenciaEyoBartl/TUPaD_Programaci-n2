
package kata_4;

/**
 *
 * @author Flo
 * Clase Animal con método hacerSonido() y describirAnimal()
 * herencia, modificadores de acceso, constructores y super
 */
public class Animal {
    
    // atributos protegidos para acceso en subclases
    
    protected String nombre;
    protected String especie;
    
    // constructor - inicializa atributos comunes
    public Animal(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
    }
    
    // método que será sobrescrito por las subclases
    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido genérico");
    }
    
    // método concreto - común para todos los animales
    public void describirAnimal() {
        System.out.println(nombre + " es un " + especie);
    }
    
    // Getters públicos para acceso controlado
    public String getNombre() {
        return nombre;
    }
    
    public String getEspecie() {
        return especie;
    }
}