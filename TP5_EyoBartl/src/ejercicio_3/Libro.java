
package ejercicio_3;


public class Libro {
    private String titulo;
    private String isbn;
    private Autor autor;        //ASOCIACIÓN UNIDIRECCIONAL
    private Editorial editorial; //AGREGACIÓN
    
    // Constructor
    public Libro(String titulo, String isbn, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;       // Asociación unidireccional
        this.editorial = editorial; // Agregación
    }
    
    // Getters
    public String getTitulo() { return titulo; }
    public String getIsbn() { return isbn; }
    public Autor getAutor() { return autor; }
    public Editorial getEditorial() { return editorial; }
    
    // Setter para AGREGACIÓN (editorial puede cambiarse)
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    
    // NO hay setter para Autor (asociación unidireccional)
    
}
