package tp3_eyobartl_utn;
public class Gallina {
        // Atributos
    private String idGallina;
    private int edad;
    private int huevosPuestos;
    // Constructor
    public Gallina(String idGallina, int edad) {
        this.idGallina = idGallina;
        this.edad = edad;
        this.huevosPuestos = 0;
    }
    // Métodos
    public void ponerHuevo() {
        if (edad >= 1) {
            huevosPuestos++;
            System.out.println(idGallina + " ha puesto un huevo. Total: " + huevosPuestos);
        } else {
            System.out.println(idGallina + " es demasiado joven para poner huevos");
        }
    }
    public void envejecer() {
        edad++;
        System.out.println(idGallina + " ha cumplido " + edad + " meses");
    }
    public void mostrarEstado() {
        System.out.println("Gallina ID: " + idGallina);
        System.out.println("Edad: " + edad + " meses");
        System.out.println("Huevos puestos: " + huevosPuestos);
    }
}
