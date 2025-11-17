package ecommerce;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Flo
 */

public class LecturaArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "archivo.txt";
        
        try {
            leerArchivo(nombreArchivo);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo '" + nombreArchivo + "' no encontrado");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    
    public static void leerArchivo(String nombreArchivo) throws FileNotFoundException {
        File archivo = new File(nombreArchivo);
        try (Scanner scanner = new Scanner(archivo)) {
            System.out.println("Contenido del archivo:");
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }
        }
    }
}
