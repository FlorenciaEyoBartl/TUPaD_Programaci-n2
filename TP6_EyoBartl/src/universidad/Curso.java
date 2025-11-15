package universidad;

public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;
    
    // Constructor
    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = null; // Inicialmente sin profesor
    }
    
    // Constructor con profesor
    public Curso(String codigo, String nombre, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        setProfesor(profesor); // Usar setProfesor para sincronización
    }
    
    // Sincronización bidireccional
    public void setProfesor(Profesor nuevoProfesor) {
        // Si ya tenía un profesor, quitarme de su lista
        if (this.profesor != null && this.profesor != nuevoProfesor) {
            this.profesor.eliminarCurso(this);
        }
        
        // Asignar nuevo profesor
        this.profesor = nuevoProfesor;
        
        // Si el nuevo profesor no es null y no tengo en su lista, agregarme
        if (nuevoProfesor != null && !nuevoProfesor.getCursos().contains(this)) {
            nuevoProfesor.agregarCurso(this);
        }
    }
    
    // Mostrar información del curso
    public void mostrarInfo() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        if (profesor != null) {
            System.out.println("Profesor: " + profesor.getNombre());
        } else {
            System.out.println("Profesor: No asignado");
        }
        System.out.println("------------------------");
    }
    
    // Getters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }
    
    @Override
    public String toString() {
        String profe = (profesor != null) ? profesor.getNombre() : "Sin profesor";
        return codigo + ": " + nombre + " - " + profe;
    }
}