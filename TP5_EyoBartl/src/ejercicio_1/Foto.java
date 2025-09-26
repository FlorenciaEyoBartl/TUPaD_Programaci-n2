
package ejercicio_1;


public class Foto {
    // Atributos
    private String imagen;
    private String formato;
    
    // Constructor
    public Foto(String imagen, String formato) {
        this.imagen = imagen;
        this.formato = formato;
    }
    
    // Getters (no setters para reforzar la composición)
    public String getImagen() { return imagen; }
    public String getFormato() { return formato; }
}
