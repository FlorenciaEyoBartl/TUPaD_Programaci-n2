//Para correr cada clase principal precione click derecho y luego "Run File"
package Ejercicio_10;

public class Principal10 {
    public static void main(String[] args) {
        // Crear titular
        Titular AGomez = new Titular("Ana Gómez", "98765432");

        // Crear cuenta con clave (composición)
        CuentaBancaria cuenta = new CuentaBancaria("0001777", 2000, "clave123", "2025-09-16");

        // Asociar titular y cuenta (bidireccional)
        cuenta.setTitular(AGomez);

        //operaciones
        cuenta.depositar(500);
        cuenta.retirar(300);

        // Mostrar resultados
        System.out.println("Titular: " + AGomez.getNombre() + " - DNI: " + AGomez.getDni());
        System.out.println("CBU de la Cuenta: " + cuenta.getCbu() + " - Saldo: " + cuenta.getSaldo());
        System.out.println("Clave: " + cuenta.getClave().getCodigo());
        
    }      
}

