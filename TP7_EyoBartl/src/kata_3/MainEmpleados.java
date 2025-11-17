
package kata_3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Flo
 * Clase principal que demuestra polimorfismo con lista de empleados
 * Upcasting, Polimorfismo, Instanceof, Downcasting
 */

public class MainEmpleados {
    public static void main(String[] args) {
        // Crear lista de empleados - UPCASTING implícito
        List<Empleado> empleados = new ArrayList<>();
        
        // .add empleados de diferentes tipos a la Lista de empleados
        empleados.add(new EmpleadoPlanta("Ana Garcia", "EMP001", 2500, 100, 5));
        empleados.add(new EmpleadoTemporal("Carlos Lopez", "EMP002", 1800, 10, 25));
        empleados.add(new EmpleadoPlanta("Maria Rodriguez", "EMP003", 2800, 120, 8));
        empleados.add(new EmpleadoTemporal("Pedro Martinez", "EMP004", 2000, 15, 30));
        empleados.add(new EmpleadoPlanta("Laura Fernandez", "EMP005", 3000, 150, 10));
        
        System.out.println("-- CALCULO DE SUELDOS USANDO POLIMORFISMO --");
        System.out.println("Lista de " + empleados.size() + " empleados:\n");
        
        // POLIMORFISMO: invocar calcularSueldo() polimórficamente
        double totalSueldos = 0;
        for (Empleado empleado : empleados) {
            double sueldo = empleado.calcularSueldo(); // Llamada polimórfica
            System.out.println("• " + empleado.getNombre() + " - Sueldo: $" + sueldo);
            totalSueldos += sueldo;
        }
        
        System.out.println("\n** CLASIFICACIÓN USANDO INSTANCEOF **");
        
        // Implementación de INSTANCEOF para clasificar empleados
        int contadorPlanta = 0;
        int contadorTemporal = 0;
        double totalPlanta = 0;
        double totalTemporal = 0;
        
        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoPlanta) {
                contadorPlanta++;
                // DOWNCASTING seguro después de verificar con instanceof
                EmpleadoPlanta planta = (EmpleadoPlanta) empleado;
                totalPlanta += planta.calcularSueldo();
                System.out.println("Empleado: " + planta.getNombre() + 
                                 " - Años antigüedad: " + planta.getAñosAntiguedad() +
                                 ", Bono: $" + planta.getBonoAntiguedad());
                
            } else if (empleado instanceof EmpleadoTemporal) {
                contadorTemporal++;
                // DOWNCASTING seguro después de verificar con instanceof
                EmpleadoTemporal temporal = (EmpleadoTemporal) empleado;
                totalTemporal += temporal.calcularSueldo();
                System.out.println("Empleado temporal:️ " + temporal.getNombre() + 
                                 " Horas extras: " + temporal.getHorasExtras() +
                                 ", Tarifa: $" + temporal.getTarifaHoraExtra());
            }
        }    
    }
}
