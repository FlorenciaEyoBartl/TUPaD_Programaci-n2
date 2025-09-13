
package tp4_eyobartl;


public class Main {

   
    public static void main(String[] args) {
         // Crear empleados usando diferentes constructores
        Empleado emp1 = new Empleado(1, "Juan Pérez", "Desarrollador", 2500.0);
        Empleado emp2 = new Empleado("María García", "Diseñadora");
        Empleado emp3 = new Empleado("Carlos López", "Analista");
        
        // Mostrar información de los empleados
        System.out.println(" EMPLEADOS ");
        System.out.println(emp1.toString());
        System.out.println(emp2.toString());
        System.out.println(emp3.toString());
        
        // Aplicar aumentos de salario con métodos sobrecargados
        System.out.println("\n ACTUALIZACIÓN DE SALARIOS ");
        emp1.actualizarSalario(10.0); // 10% de aumento
        emp2.actualizarSalario(500);  // $500 de aumento
        
        System.out.println("Después de los aumentos:");
        System.out.println(emp1.toString());
        System.out.println(emp2.toString());
        
        // Mostrar total de empleados usando el método estático
        System.out.println("\n TOTAL DE EMPLEADOS");
        System.out.println("Total de empleados creados: " + Empleado.mostrarTotalEmpleados());
        
        // Encapsulamiento usando getters y setters
        System.out.println("\n ENCAPSULAMIENTO ");
        System.out.println("Nombre del empleado 1: " + emp1.getNombre());
        emp1.setPuesto("Senior Developer");
        System.out.println("Nuevo puesto del empleado 1: " + emp1.getPuesto());
    }
        
    }
    

