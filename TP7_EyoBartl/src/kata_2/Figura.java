
package kata_2;

/**
 * @author Flo
 * Clase abstracta Figura con método abstracto calcularArea()
 * (clases abstractas, métodos abstractos y modificadores de acceso)
 */
public abstract class Figura {
    
    // Atributo nombre - protected para acceso en subclases
    @SuppressWarnings("ProtectedField")
    protected String nombre;
    
    // Constructor (inicializa atributos comunes)
    public Figura(String nombre) {
        this.nombre = nombre;
    }
    
    // Método abstracto (debe ser implementado por las subclases)
    public abstract double calcularArea();
    
    // Getter para nombre (public para acceso controlado)
    public String getNombre() {
        return nombre;
    }
    
    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}