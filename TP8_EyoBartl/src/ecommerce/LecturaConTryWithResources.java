package ecommerce;

/**
 *
 * @author Flo
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecturaConTryWithResources {
    public static void main(String[] args) {
        String nombreArchivo = "datos.txt";
        
        try {
            leerArchivoConRecursos(nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
    
    public static void leerArchivoConRecursos(String nombreArchivo) throws IOException {
        // try-with-resources cierra automáticamente el BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            System.out.println("Contenido del archivo:");
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        }
        // No es necesario finally, el recurso se cierra automáticamente
    }
}
