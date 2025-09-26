
package Ejercicio_9;

public class CitaMedica {
        private String fecha;
    private String hora;
    private Paciente paciente;       //ASOCIACIÓN UNIDIRECCIONAL (1)
    private Profesional profesional; //ASOCIACIÓN UNIDIRECCIONAL (1)
    
    // Constructor
        public CitaMedica(String fecha, String hora, Paciente paciente, Profesional profesional) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;     //Asociación unidireccional
        this.profesional = profesional; //Asociación unidireccional
    }
    
    // Getters
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public Paciente getPaciente() { return paciente; }
    public Profesional getProfesional() { return profesional; }
    
    // NO hay setters (asociaciones unidireccionales)
}
