package tp3_eyobartl_utn;
public class Mascota {
     // Atributos
    private String nombre;
    private String especie;
    private int edad;
    // Constructor
    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }
    // Métodos
    public void mostrarInfo() {
        System.out.println("Mascota: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
    }
    public void cumplirAnios() {
        edad++;
        System.out.println("¡Feliz cumpleaños! " + nombre + " ahora tiene " + edad + " años");
    }
}