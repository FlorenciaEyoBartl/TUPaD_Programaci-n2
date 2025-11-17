
package kata_3;

/**
 * @author Flo
 * Clase abstracta Empleado con método abstracto calcularSueldo()
 * Clases abstractas, Métodos abstractos, Modificadores de acceso
 */
public abstract class Empleado {
    // Atributos protegidos para acceso en subclases
    protected String nombre;
    protected String id;
    protected double salarioBase;
    
    // Constructor - inicializa atributos comunes
    public Empleado(String nombre, String id, double salarioBase) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
    }
    
    // Método abstracto - debe ser implementado por las subclases
    public abstract double calcularSueldo();
    
    // Método concreto - común para todos los empleados
    public void mostrarInformacionBasica() {
        System.out.println("Empleado: " + nombre + " (ID: " + id + ")");
        System.out.println("Salario base: $" + salarioBase);
    }
    
    // Getters públicos para acceso controlado
    public String getNombre() {
        return nombre;
    }
    
    public String getId() {
        return id;
    }
    
    public double getSalarioBase() {
        return salarioBase;
    }
}
