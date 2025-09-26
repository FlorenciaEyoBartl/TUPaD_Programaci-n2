
package Ejercicio_8;


public class FirmaDigital {
     private String codigoHash;
    private String fecha;
    private Usuario usuario; //Agregación 
    
    // Constructor
    public FirmaDigital(String codigoHash, String fecha, Usuario usuario) {
        this.codigoHash = codigoHash;
        this.fecha = fecha;
        this.usuario = usuario; //Agregación
    }
    
    // Getters
    public String getCodigoHash() { return codigoHash; }
    public String getFecha() { return fecha; }
    public Usuario getUsuario() { return usuario; }
    
    // Setter para AGREGACIÓN, usuario puede cambiarse
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
