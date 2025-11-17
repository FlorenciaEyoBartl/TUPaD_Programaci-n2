package ecommerce;

import java.util.Scanner;

/**
 * * @author Flo
 */
public class DivisionSegura {
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el dividendo: ");
            int dividendo = scanner.nextInt();
            
            System.out.print("Ingrese el divisor: ");
            int divisor = scanner.nextInt();
            
            double resultado = dividir(dividendo, divisor);
            System.out.println("Resultado: " + resultado);
            
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir por cero");
        } catch (Exception e) {
            System.out.println("Error: entrada invalida");
        }
    }
    
    public static double dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisor cero");
        }
        return (double) a / b;
    }
}