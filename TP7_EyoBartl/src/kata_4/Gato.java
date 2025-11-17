
package kata_4;

/**
 * @author Flo
 * Subclase Gato que sobrescribe hacerSonido()
 * herencia (extends), constructores y super, sobrescritura (@Override)
 */

public class Gato extends Animal {
    
    // constructor que llama al constructor de la superclase
    public Gato(String nombre) {
        super(nombre, "Gato"); // invocación al constructor de la superclase
    }
    
    // sobrescritura del método hacerSonido() - polimorfismo
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: Miau ");
    }
}