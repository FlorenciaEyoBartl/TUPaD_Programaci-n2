package universidad;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String id;
    private String nombre;
    private String especialidad;
    private List<Curso> cursos;
    
    // Constructor
    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>();
    }
    
    // Agregar curso (sincronización bidireccional)
    public void agregarCurso(Curso c) {
        if (!cursos.contains(c)) {
            cursos.add(c);
            // Sincronizar el lado del curso
            if (c.getProfesor() != this) {
                c.setProfesor(this);
            }
            System.out.println("Curso " + c.getNombre() + " agregado al profesor " + nombre);
        }
    }
    
    // Eliminar curso (sincronización bidireccional)
    public void eliminarCurso(Curso c) {
        if (cursos.contains(c)) {
            cursos.remove(c);
            // Sincronizar el lado del curso
            if (c.getProfesor() == this) {
                c.setProfesor(null);
            }
            System.out.println("Curso " + c.getNombre() + " eliminado del profesor " + nombre);
        }
    }
    
    // Listar cursos del profesor
    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("El profesor " + nombre + " no dicta ningún curso.");
            return;
        }
        
        System.out.println("=== CURSOS DICTADOS POR " + nombre.toUpperCase() + " ===");
        for (Curso curso : cursos) {
            System.out.println("- " + curso.getCodigo() + ": " + curso.getNombre());
        }
    }
    
    // Mostrar información del profesor
    public void mostrarInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Cursos asignados: " + cursos.size());
        System.out.println("------------------------");
    }
    
    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public List<Curso> getCursos() { return cursos; }
    
    @Override
    public String toString() {
        return nombre + " (" + especialidad + ") - Cursos: " + cursos.size();
    }
}