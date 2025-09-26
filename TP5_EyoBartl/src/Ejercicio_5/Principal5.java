//Para correr cada clase principal precione click derecho y luego "Run File"
package Ejercicio_5;


public class Principal5 {
    public static void main(String[] args) {
        System.out.println("EJERCICIO 5");
        
        //Crear Propietario
        Propietario propietario = new Propietario("Carlos Gómez", "40123456");
        
        //Crear Computadora (crea su propia placa madre por COMPOSICIÓN)
        Computadora computadora = new Computadora("Dell", "SN123456", 
                                                "ASUS B550", "AMD B550");
        
        //ASOCIACIÓN BIDIRECCIONAL
        computadora.setPropietario(propietario);
        
        //relaciones
        System.out.println("Propietario: " + propietario.getNombre());
        System.out.println("Computadora: " + computadora.getMarca() + 
                         " (" + computadora.getNumeroSerie() + ")");
        System.out.println("Placa Madre: " + computadora.getPlacaMadre().getModelo() +
                         " (" + computadora.getPlacaMadre().getChipset() + ")");
        
        //Bidireccionalidad
        System.out.println("¿Coinciden referencias? " + 
                          (propietario.getComputadora() == computadora)); // true
        
        //cardinalidad (computadora sin propietario)
        Computadora compuSinDueño = new Computadora("HP", "SN789012", 
                                                  "Gigabyte Z690", "Intel Z690");
        System.out.println("Computadora sin dueño: " + compuSinDueño.getMarca());
        System.out.println("Propietario: " + compuSinDueño.getPropietario()); // null
        
    }
}
