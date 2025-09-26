
package Ejercicio_12;

public class Calculadora {

    // Dependencia de uso: recibe Impuesto como parámetro pero no lo guarda
    public void calcular(Impuesto impuesto) {
        double monto = impuesto.getMonto();
        double total = monto * 1.21; // ejemplo: suma 21% de IVA
        System.out.println("Contribuyente: " + impuesto.getContribuyente().getNombre() +
                " | CUIL: " + impuesto.getContribuyente().getCuil() +
                " | Monto base: $" + monto +
                " | Total con impuestos: $" + total);
    }
}
