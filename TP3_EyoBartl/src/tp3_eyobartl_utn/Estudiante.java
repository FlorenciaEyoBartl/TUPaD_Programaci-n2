package tp3_eyobartl_utn;
public class Estudiante {
    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion;
    // Constructor
    public Estudiante(String nombre, String apellido, String curso, double calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.calificacion = calificacion;
    }
    // Métodos
    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " " + apellido);
        System.out.println("Curso: " + curso);
        System.out.println("Calificación: " + calificacion);
    }
    public void subirCalificacion(double puntos) {
        if (puntos > 0) {
            calificacion += puntos;
            if (calificacion > 10) {
                calificacion = 10;
            }
            System.out.println("Calificación aumentada a: " + calificacion);
        }
    }
    public void bajarCalificacion(double puntos) {
        if (puntos > 0) {
            calificacion -= puntos;
            if (calificacion < 0) {
                calificacion = 0;
            }
            System.out.println("Calificación disminuida a: " + calificacion);
        }
     }
}
