package universidad;

public class Main_U {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA UNIVERSITARIO ===");
        
        // Crear universidad
        Universidad universidad = new Universidad("Universidad Nacional");
        
        // Crear al menos 3 profesores
        Profesor prof1 = new Profesor("P001", "Dr. Carlos Méndez", "Matemáticas");
        Profesor prof2 = new Profesor("P002", "Dra. Ana López", "Física");
        Profesor prof3 = new Profesor("P003", "Mg. Pedro Rodríguez", "Programación");
        
        // Crear 5 cursos
        Curso curso1 = new Curso("MAT101", "Cálculo I");
        Curso curso2 = new Curso("MAT102", "Cálculo II");
        Curso curso3 = new Curso("FIS101", "Física");
        Curso curso4 = new Curso("PROG101", "Programación I");
        Curso curso5 = new Curso("PROG102", "Programación II");
        
        // Agregar profesores y cursos a la universidad
        universidad.agregarProfesor(prof1);
        universidad.agregarProfesor(prof2);
        universidad.agregarProfesor(prof3);
        
        universidad.agregarCurso(curso1);
        universidad.agregarCurso(curso2);
        universidad.agregarCurso(curso3);
        universidad.agregarCurso(curso4);
        universidad.agregarCurso(curso5);
        
        System.out.println("\n" + "=".repeat(50));
        
        // Asignar profesores a cursos
        System.out.println("ASIGNANDO PROFESORES A CURSOS:");
        universidad.asignarProfesorACurso("MAT101", "P001");
        universidad.asignarProfesorACurso("MAT102", "P001");
        universidad.asignarProfesorACurso("FIS101", "P002");
        universidad.asignarProfesorACurso("PROG101", "P003");
        universidad.asignarProfesorACurso("PROG102", "P003");
        
        System.out.println("\n" + "=".repeat(50));
        
        // Listar cursos con profesor y profesores con sus cursos
        System.out.println("LISTA DE CURSOS:");
        universidad.listarCursos();
        
        System.out.println("\nLISTA DE PROFESORES:");
        universidad.listarProfesores();
        
        System.out.println("\n" + "=".repeat(50));
        
        // Cambiar profesor de un curso y verificar sincronización
        System.out.println("CAMBIANDO PROFESOR DE CURSO:");
        System.out.println("ANTES del cambio:");
        curso1.mostrarInfo();
        prof1.listarCursos();
        prof2.listarCursos();
        
        universidad.asignarProfesorACurso("MAT101", "P002");
        
        System.out.println("\nLuego del cambio:");
        curso1.mostrarInfo();
        prof1.listarCursos();
        prof2.listarCursos();
        
        System.out.println("\n" + "=".repeat(50));
        
        // Remover un curso y confirmar que ya no aparece en la lista del profesor
        System.out.println("ELIMINANDO CURSO:");
        prof3.listarCursos();
        universidad.eliminarCurso("PROG101");
        prof3.listarCursos();
        
        System.out.println("\n" + "=".repeat(50));
        
        // Remover un profesor y dejar profesor = null en sus cursos
        System.out.println("ELIMINANDO PROFESOR:");
        curso2.mostrarInfo();
        universidad.eliminarProfesor("P001");
        curso2.mostrarInfo(); // Debería mostrar "Sin profesor"
        
        System.out.println("\n" + "=".repeat(50));
        
        // Mostrar reporte: cantidad de cursos por profesor
        universidad.mostrarReporteCursosPorProfesor();
        
        // Verificación final del estado
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ESTADO FINAL:");
        universidad.listarCursos();
        universidad.listarProfesores();
    }
}