//Para correr cada clase principal precione click derecho y luego "Run File"
package Ejercicio_11;

public class Principal11 {
    public static void main(String[] args) {
        // Crear artista
        Artista artista = new Artista("Shakira", "Pop");

        // Crear canción con asociación a artista
        Cancion cancion = new Cancion("Monotonia", artista);

        // Crear reproductor y usar dependencia de uso
        Reproductor reproductor = new Reproductor();
        reproductor.reproducir(cancion);
    }
    
}
