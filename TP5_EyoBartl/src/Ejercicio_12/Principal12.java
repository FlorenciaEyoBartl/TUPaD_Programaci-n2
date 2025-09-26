//Para correr cada clase principal precione click derecho y luego "Run File"
package Ejercicio_12;


public class Principal12 {
     public static void main(String[] args) {
        // Crear contribuyente
        Contribuyente contribuyente = new Contribuyente("Mar López", "20-12345678-9");

        // Crear impuesto asociado al contribuyente
        Impuesto impuesto = new Impuesto(10000, contribuyente);

        // Crear calculadora y usar dependencia de uso
        Calculadora calculadora = new Calculadora();
        calculadora.calcular(impuesto);
    }
}
