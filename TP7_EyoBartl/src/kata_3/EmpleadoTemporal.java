
package kata_3;

/**
 *
 * @author Flo
 * Subclase EmpleadoTemporal que implementa calcularSueldo()
 * Aplica: Herencia (extends), Constructores y super, Sobrescritura (@Override)
 */

public class EmpleadoTemporal extends Empleado {
    // Atributos privados - encapsulación
    private int horasExtras;
    private double tarifaHoraExtra;
    
    // Constructor que llama al constructor de la superclase
    public EmpleadoTemporal(String nombre, String id, double salarioBase, 
                           int horasExtras, double tarifaHoraExtra) {
        super(nombre, id, salarioBase); // Invocación al constructor de la superclase
        this.horasExtras = horasExtras;
        this.tarifaHoraExtra = tarifaHoraExtra;
    }
    
    // Implementación del método abstracto - polimorfismo
    @Override
    public double calcularSueldo() {
        return salarioBase + (horasExtras * tarifaHoraExtra);
    }
    
    // Getters específicos - control de acceso
    public int getHorasExtras() {
        return horasExtras;
    }
    
    public double getTarifaHoraExtra() {
        return tarifaHoraExtra;
    }
    
    // Método específico de EmpleadoTemporal
    public void mostrarInformacionCompleta() {
        mostrarInformacionBasica();
        System.out.println("Tipo: Empleado Temporal");
        System.out.println("Horas extras: " + horasExtras);
        System.out.println("Tarifa hora extra: $" + tarifaHoraExtra);
        System.out.println("Sueldo total: $" + calcularSueldo());
    }
}