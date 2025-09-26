
//Para correr cada clase principal precione click derecho y luego "Run File"
package Ejercicio_9;


public class Principal9 {
     public static void main(String[] args) {
        System.out.println("EJERCICIO 9");
        
        //Crear Paciente (asociación unidireccional)
        Paciente paciente = new Paciente("María González", "OSDE");
        
        //Crear Profesional (asociación unidireccional)
        Profesional profesional = new Profesional("Dr. Carlos López", "Cardiología");
        
        //Crear CitaMédica con Paciente y Profesional
        CitaMedica cita = new CitaMedica("2024-01-20", "10:30", paciente, profesional);
        
        //relaciones
        System.out.println("Cita Médica: " + cita.getFecha() + " a las " + cita.getHora());
        System.out.println("Paciente: " + cita.getPaciente().getNombre() +
                         " (Obra Social: " + cita.getPaciente().getObraSocial() + ")");
        System.out.println("Profesional: " + cita.getProfesional().getNombre() +
                         " (Especialidad: " + cita.getProfesional().getEspecialidad() + ")");
        
        //ASOCIACIÓN UNIDIRECCIONAL
        // El paciente NO sabe sobre la cita (solo la cita conoce al paciente)
        System.out.println("El paciente no tiene referencia a la cita: " + 
                          (paciente instanceof Paciente)); // true, pero no tiene método getCita()
        
        // El profesional NO sabe sobre la cita (solo la cita conoce al profesional)
        System.out.println("El profesional no tiene referencia a la cita: " + 
                          (profesional instanceof Profesional)); // true, pero no tiene método getCita()
        
        //cardinalidad * (múltiples citas para mismo paciente)
        CitaMedica cita2 = new CitaMedica("2024-02-01", "11:00", paciente, profesional);
        System.out.println("Segunda cita para el mismo paciente: " + cita2.getFecha());
        
        // 7. Demostrar que paciente y profesional existen independientemente
        System.out.println("Paciente sigue existiendo: " + paciente.getNombre());
        System.out.println("Profesional sigue existiendo: " + profesional.getNombre());
        
    }
}
