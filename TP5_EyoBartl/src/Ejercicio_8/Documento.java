
package Ejercicio_8;


public class Documento {
    private String titulo;
    private String contenido;
    private FirmaDigital firma; //COMPOSICIÓN
    
    //Constructor, ocurre la COMPOSICIÓN
    public Documento(String titulo, String contenido, 
                    String codigoHash, String fecha, Usuario usuario) {
        this.titulo = titulo;
        this.contenido = contenido;
        //COMPOSICIÓN la firma se crea DENTRO del documento
        this.firma = new FirmaDigital(codigoHash, fecha, usuario);
    }
    
    //Getters
    public String getTitulo() { return titulo; }
    public String getContenido() { return contenido; }
    public FirmaDigital getFirma() { return firma; }
    
    // NO hay setters para composición de la firma
}
