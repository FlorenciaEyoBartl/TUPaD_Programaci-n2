package biblioteca;

public class Autor {
    private String id;
    private String nombre;
    private String nacionalidad;
    
    // Constructor
    public Autor(String id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    
    // Método mostrarInfo
    public void mostrarInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("------------------------");
    }
    
    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getNacionalidad() { return nacionalidad; }
    
    @Override
    public String toString() {
        return nombre + " (" + nacionalidad + ")";
    }
}