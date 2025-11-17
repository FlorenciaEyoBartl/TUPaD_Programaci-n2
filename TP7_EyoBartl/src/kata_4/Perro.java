
package kata_4;

/**
 * @author Flo
 * Subclase Perro que sobrescribe hacerSonido()
 * herencia (extends), constructores y super, sobrescritura (@Override)
 */
public class Perro extends Animal {
    
    // constructor que llama al constructor de la superclase
    public Perro(String nombre) {
        super(nombre, "Perro"); // invocación al constructor de la superclase
    }
    
    // sobrescritura del método hacerSonido() - polimorfismo
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: Guau ");
    }
}
