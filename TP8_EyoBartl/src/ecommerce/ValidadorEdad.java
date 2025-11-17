package ecommerce;

// @author Flo
 
// Clase para validar edad
public class ValidadorEdad {
    
    public static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0) {
            throw new EdadInvalidaException("La edad no puede ser negativa: " + edad);
        }
        if (edad > 120) {
            throw new EdadInvalidaException("La edad no puede ser mayor a 120: " + edad);
        }
    }
    
    public static void main(String[] args) {
        int[] edades = {25, -5, 150, 30};
        
        for (int edad : edades) {
            try {
                validarEdad(edad);
                System.out.println("Edad valida: " + edad);
            } catch (EdadInvalidaException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
