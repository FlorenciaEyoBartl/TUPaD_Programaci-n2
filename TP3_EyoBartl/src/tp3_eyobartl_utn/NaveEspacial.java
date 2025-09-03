package tp3_eyobartl_utn;
public class NaveEspacial {
    // Atributos
    private String nombre;
    private double combustible;
    private final double COMBUSTIBLE_MAXIMO = 100;
    private final double CONSUMO_POR_KM = 0.5;
    // Constructor
    public NaveEspacial(String nombre, double combustible) {
        this.nombre = nombre;
        if (combustible <= COMBUSTIBLE_MAXIMO) {
            this.combustible = combustible;
        } else {
            this.combustible = COMBUSTIBLE_MAXIMO;
            System.out.println("Combustible inicial excede el máximo. Se estableció a " + COMBUSTIBLE_MAXIMO);
        }
    }
    // Métodos
    public void despegar() {
        if (combustible >= 10) {
            combustible -= 10;
            System.out.println(nombre + " ha despegado. Combustible restante: " + combustible);
        } else {
            System.out.println("No hay suficiente combustible para despegar");
        }
    }
    public void avanzar(double distancia) {
        double combustibleNecesario = distancia * CONSUMO_POR_KM;
        if (combustible >= combustibleNecesario) {
            combustible -= combustibleNecesario;
            System.out.println(nombre + " avanzó " + distancia + " km. Combustible restante: " + combustible);
        } else {
            System.out.println("No hay suficiente combustible para avanzar " + distancia + " km");
            System.out.println("Se necesitan " + combustibleNecesario + " unidades, pero solo hay " + combustible);
        }
    }
    public void recargarCombustible(double cantidad) {
        if (cantidad > 0) {
            if (combustible + cantidad <= COMBUSTIBLE_MAXIMO) {
                combustible += cantidad;
                System.out.println("Se recargaron " + cantidad + " unidades de combustible. Total: " + combustible);
            } else {
                combustible = COMBUSTIBLE_MAXIMO;
                System.out.println("Se excede el límite de combustible. Se estableció a " + COMBUSTIBLE_MAXIMO);
            }
        }
    }
    public void mostrarEstado() {
        System.out.println("Nave: " + nombre);
        System.out.println("Combustible: " + combustible + "/" + COMBUSTIBLE_MAXIMO);
    }
}
