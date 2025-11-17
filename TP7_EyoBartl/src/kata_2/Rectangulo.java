
package kata_2;

/**
 * @author Flo
 * Subclase Rectangulo que implementa calcularArea()
 */

public class Rectangulo extends Figura {
    
    // atributos privados - encapsulación
    private double base;
    private double altura;
    
    // Constructor que llama al constructor de la superclase
    public Rectangulo(String nombre, double base, double altura) {
        super(nombre); // Invocación al constructor de la superclase
        this.base = base;
        this.altura = altura;
    }
    
    // Implementación del método abstracto - polimorfismo
    @Override
    public double calcularArea() {
        return base * altura;
    }
    
    // Getters y setters - control de acceso
    public double getBase() {
        return base;
    }
    
    public void setBase(double base) {
        this.base = base;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }
}