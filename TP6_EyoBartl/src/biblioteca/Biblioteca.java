
package biblioteca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Biblioteca {
    private String nombre;
    private List<Libro> libros;
    // Composición 1 a N
    // Biblioteca contiene Libros, si se elimina la biblioteca se eliminan sus libros
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }
    
    // Agregar libro
    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        Libro nuevoLibro = new Libro(isbn, titulo, anioPublicacion, autor);
        libros.add(nuevoLibro);
        System.out.println("Libro agregado: " + titulo);
    }
    
    // Listar todos los libros
    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }
        
        System.out.println("LISTA DE LIBROS: " + nombre.toUpperCase());
        for (Libro libro : libros) {
            libro.mostrarInfo();
        }
    }
    
    // Buscar libro por ISBN
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null; // No encontrado
    }
    
    // Eliminar libro por ISBN
    public boolean eliminarLibro(String isbn) {
        Libro libro = buscarLibroPorIsbn(isbn);
        if (libro != null) {
            libros.remove(libro);
            System.out.println("Libro eliminado: " + libro.getTitulo());
            return true;
        }
        System.out.println("No se encontró libro con ISBN: " + isbn);
        return false;
    }
    
    // Obtener cantidad de libros
    public int obtenerCantidadLibros() {
        return libros.size();
    }
    
    // Filtrar libros por año
    public void filtrarLibrosPorAnio(int anio) {
        System.out.println("=== LIBROS PUBLICADOS EN " + anio + " ===");
        boolean encontrado = false;
        
        for (Libro libro : libros) {
            if (libro.getAnioPublicacion() == anio) {
                libro.mostrarInfo();
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("No hay libros publicados en el año " + anio);
        }
    }
    
    // Mostrar autores disponibles
    public void mostrarAutoresDisponibles() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }
        
        // Usamos Set para evitar autores duplicados
        Set<Autor> autoresUnicos = new HashSet<>();
        
        for (Libro libro : libros) {
            autoresUnicos.add(libro.getAutor());
        }
        
        System.out.println("AUTORES DISPONIBLES");
        for (Autor autor : autoresUnicos) {
            autor.mostrarInfo();
        }
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public List<Libro> getLibros() { return libros; }
}