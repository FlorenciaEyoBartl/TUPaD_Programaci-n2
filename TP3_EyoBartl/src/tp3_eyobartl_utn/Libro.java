package tp3_eyobartl_utn;
public class Libro {
    // Atributos privados
    private String titulo;
    private String autor;
    private int añoPublicacion;
    // Constructor
    public Libro(String titulo, String autor, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        setAñoPublicacion(añoPublicacion); // Usamos el setter para validación
    }
    // Getters
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public int getAñoPublicacion() {
        return añoPublicacion;
    }
    // Setter con validación
    public void setAñoPublicacion(int añoPublicacion) {
        int añoActual = java.time.Year.now().getValue();
        if (añoPublicacion <= añoActual && añoPublicacion > 0) {
            this.añoPublicacion = añoPublicacion;
        } else {
            System.out.println("Año de publicación inválido. Debe ser entre 1 y " + añoActual);
        }
    }
    // Método para mostrar información
    public void mostrarInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de publicación: " + añoPublicacion);
    }
}