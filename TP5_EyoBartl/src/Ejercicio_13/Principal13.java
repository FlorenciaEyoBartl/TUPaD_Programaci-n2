//Para correr cada clase principal precione click derecho y luego "Run File"
package Ejercicio_13;


public class Principal13 {
    
     public static void main(String[] args) {
        // Crear usuario
        Usuario usuario = new Usuario("Juan Pérez", "juan.perez@email.com");

        // Crear generador de QR
        GeneradorQR generador = new GeneradorQR();

        // Generar un código QR (dependencia de creación)
        generador.generar("QR-2025-001", usuario);
    }
}
