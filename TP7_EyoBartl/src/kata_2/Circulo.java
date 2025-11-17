
package kata_2;

/**
 * @author Flo
 * Subclase Círculo que implementa calcularArea()
 */

// herencia extensds 
public class Circulo extends Figura {
    
    // atributo privado - encapsulación
    private double radio;
    
    // constructor que llama al constructor de la superclase
    public Circulo(String nombre, double radio) {
        super(nombre); // Invocación al constructor de la superclase
        this.radio = radio;
    }
    
    // implementación del método abstracto - polimorfismo
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
    
    // Getters y setters - control de acceso
    public double getRadio() {
        return radio;
    }
    
    public void setRadio(double radio) {
        this.radio = radio;
    }
}