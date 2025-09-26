
package ejercicio_2;


public class Celular {
    private String imei;
    private String marca;
    private String modelo;
    private Bateria bateria;   //AGREGACIÓN (se inyecta)
    private Usuario usuario;   //ASOCIACIÓN BIDIRECCIONAL
    
    // Constructor SIN batería (agregación)
    public Celular(String imei, String marca, String modelo) {
        this.imei = imei;
        this.marca = marca;
        this.modelo = modelo;
        this.bateria = null; // Inicialmente sin batería
    }
    
    // Getters
    public String getImei() { return imei; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public Bateria getBateria() { return bateria; }
    public Usuario getUsuario() { return usuario; }
    
    // Setter para AGREGACIÓN (batería)
    public void setBateria(Bateria bateria) {
        this.bateria = bateria;
    }
    
    // Setter para ASOCIACIÓN BIDIRECCIONAL (usuario)
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        // Bidireccionalidad
        if (usuario != null) {
            usuario.setCelular(this);
        }
    }
}
