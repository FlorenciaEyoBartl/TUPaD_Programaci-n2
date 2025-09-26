
package ejercicio_1;


public class Pasaporte {
     // Atributos
    private String numero;
    private String fechaEmision;
    private Foto foto;           //  COMPOSICIÓN
    private Titular titular;     //  ASOCIACIÓN BIDIRECCIONAL
    
    // Constructor - Aquí ocurre la COMPOSICIÓN
    public Pasaporte(String numero, String fechaEmision, 
                    String imagenFoto, String formatoFoto) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        // COMPOSICIÓN: la foto se crea DENTRO del pasaporte
        this.foto = new Foto(imagenFoto, formatoFoto);
    }
    
    // Getters
    public String getNumero() { return numero; }
    public String getFechaEmision() { return fechaEmision; }
    public Foto getFoto() { return foto; }
    public Titular getTitular() { return titular; }
    
    // Setter para establecer la asociación bidireccional
    // Para que no se haga un bucle infinito se demuestra la bidireccionalidad
    public void setTitular(Titular titular) {
        this.titular = titular;
        // BIDIRECCIONALIDAD: el titular también conoce este pasaporte
        if (titular != null && titular.getPasaporte() != this) {
            titular.setPasaporte(this);
        }
    }
   

}
