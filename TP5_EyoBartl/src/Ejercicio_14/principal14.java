//Para correr cada clase principal precione click derecho y luego "Run File"
package Ejercicio_14;


public class principal14 {
    
    public static void main(String[] args) {
        // Crear proyecto
        Proyecto proyecto = new Proyecto("Corto Animado", 15);

        // Crear editor de video
        EditorVideo editor = new EditorVideo();

        // Exportar proyecto (dependencia de creación)
        editor.exportar("MP4", proyecto);
    }
}
