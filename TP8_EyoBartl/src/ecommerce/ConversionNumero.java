package ecommerce;

import java.util.Scanner;

/**
 * @author Flo
 */
public class ConversionNumero {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese un numero: ");
        String entrada = scanner.nextLine();
        
        try {
            int numero = Integer.parseInt(entrada);
            System.out.println("Numero convertido: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Error: '" + entrada + "' no es un numero valido");
        } finally {
            scanner.close();
        }
    }
}