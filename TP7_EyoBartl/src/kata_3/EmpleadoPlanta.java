
package kata_3;

/**
 *
 * @author Flo
 * Subclase EmpleadoPlanta que implementa calcularSueldo()
 * Herencia (extends), Constructores y super, Sobrescritura (@Override)
 */

public class EmpleadoPlanta extends Empleado {
    // Atributos privados - encapsulación
    private double bonoAntiguedad;
    private int añosAntiguedad;
    
    // Constructor que llama al constructor de la superclase
    public EmpleadoPlanta(String nombre, String id, double salarioBase, 
                         double bonoAntiguedad, int añosAntiguedad) {
        super(nombre, id, salarioBase); // Invocación al constructor de la superclase
        this.bonoAntiguedad = bonoAntiguedad;
        this.añosAntiguedad = añosAntiguedad;
    }
    
    // Implementación del método abstracto - polimorfismo
    @Override
    public double calcularSueldo() {
        return salarioBase + (bonoAntiguedad * añosAntiguedad);
    }
    
    // Getters específicos - control de acceso
    public double getBonoAntiguedad() {
        return bonoAntiguedad;
    }
    
    public int getAñosAntiguedad() {
        return añosAntiguedad;
    }
    
    // Método específico de EmpleadoPlanta
    public void mostrarInformacionCompleta() {
        mostrarInformacionBasica();
        System.out.println("Tipo: Empleado de Planta");
        System.out.println("Años de antigüedad: " + añosAntiguedad);
        System.out.println("Bono por antigüedad: $" + bonoAntiguedad);
        System.out.println("Sueldo total: $" + calcularSueldo());
    }
}