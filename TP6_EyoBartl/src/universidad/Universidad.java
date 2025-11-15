package universidad;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;
    
    // Constructor
    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }
    
    // Agregar profesor
    public void agregarProfesor(Profesor p) {
        if (!profesores.contains(p)) {
            profesores.add(p);
            System.out.println("Profesor agregado: " + p.getNombre());
        }
    }
    
    // Agregar curso
    public void agregarCurso(Curso c) {
        if (!cursos.contains(c)) {
            cursos.add(c);
            System.out.println("Curso agregado: " + c.getNombre());
        }
    }
    
    // Asignar profesor a curso 
    public boolean asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profesor = buscarProfesorPorId(idProfesor);
        
        if (curso != null && profesor != null) {
            curso.setProfesor(profesor); // Usa el setter que sincroniza automáticamente
            System.out.println("Profesor " + profesor.getNombre() + 
                             " asignado al curso " + curso.getNombre());
            return true;
        }
        
        if (curso == null) {
            System.out.println("No se encontró curso con código: " + codigoCurso);
        }
        if (profesor == null) {
            System.out.println("No se encontró profesor con ID: " + idProfesor);
        }
        return false;
    }
    
    // Listar profesores
    public void listarProfesores() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores en la universidad.");
            return;
        }
        
        System.out.println("=== PROFESORES DE " + nombre.toUpperCase() + " ===");
        for (Profesor profesor : profesores) {
            profesor.mostrarInfo();
        }
    }
    
    // Listar cursos
    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos en la universidad.");
            return;
        }
        
        System.out.println("=== CURSOS DE " + nombre.toUpperCase() + " ===");
        for (Curso curso : cursos) {
            curso.mostrarInfo();
        }
    }
    
    // Buscar profesor por ID
    public Profesor buscarProfesorPorId(String id) {
        for (Profesor p : profesores) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
    
    // Buscar curso por código
    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }
    
    // Eliminar curso
    public boolean eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);
        if (curso != null) {
            // Romper relación con profesor si existe
            if (curso.getProfesor() != null) {
                curso.getProfesor().eliminarCurso(curso);
            }
            cursos.remove(curso);
            System.out.println("Curso eliminado: " + curso.getNombre());
            return true;
        }
        System.out.println("No se encontró curso con código: " + codigo);
        return false;
    }
    
    // Eliminar profesor
    public boolean eliminarProfesor(String id) {
        Profesor profesor = buscarProfesorPorId(id);
        if (profesor != null) {
            // Dejar null en todos los cursos que dictaba
            for (Curso curso : new ArrayList<>(profesor.getCursos())) {
                curso.setProfesor(null);
            }
            profesores.remove(profesor);
            System.out.println("Profesor eliminado: " + profesor.getNombre());
            return true;
        }
        System.out.println("No se encontró profesor con ID: " + id);
        return false;
    }
    
    // Reporte: cantidad de cursos por profesor
    public void mostrarReporteCursosPorProfesor() {
        System.out.println("=== REPORTE: CURSOS POR PROFESOR ===");
        for (Profesor profesor : profesores) {
            System.out.println(profesor.getNombre() + ": " + 
                             profesor.getCursos().size() + " cursos");
        }
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public List<Profesor> getProfesores() { return profesores; }
    public List<Curso> getCursos() { return cursos; }
}