
package kata_4;

/**
 *
 * @author FloSubclase Vaca que sobrescribe hacerSonido()
 * herencia (extends), constructores y super, sobrescritura (@Override)
 */
public class Vaca extends Animal {
    
    // constructor que llama al constructor de la superclase
    public Vaca(String nombre) {
        super(nombre, "Vaca"); // invocación al constructor de la superclase
    }
    
    // sobrescritura del método hacerSonido() - polimorfismo
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: Muuuu");
    }
}