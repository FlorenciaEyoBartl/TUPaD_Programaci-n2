
package Ejercicio_11;

public class Reproductor {

    // Dependencia de uso (recibe Cancion como parámetro pero no la guarda)
    public void reproducir(Cancion cancion) {
        System.out.println("Reproduciendo: " + cancion.getTitulo() +
                " - Artista: " + cancion.getArtista().getNombre() +
                " (" + cancion.getArtista().getGenero() + ")");
    }
}
