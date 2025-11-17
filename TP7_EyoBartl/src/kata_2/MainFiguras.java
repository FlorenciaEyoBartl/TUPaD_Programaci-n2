package kata_2;

/**
 * @author Flo
 * Clase principal que demuestra polimorfismo con array de figuras
 * (Upcasting, Polimorfismo, Instanceof, Downcasting)
 */
public class MainFiguras {
    public static void main(String[] args) {
        
        // Crear un array de figuras (Upcasting implícito)
        Figura[] figuras = {
            new Circulo("Circulo Pequeño", 3.0),
            new Rectangulo("Rectangulo Grande", 8.0, 6.0),
            new Circulo("Circulo Grande", 5.0),
            new Rectangulo("Rectangulo Pequeño", 4.0, 3.0)
        };
        
        System.out.println("-- CALCULO DE AREAS USANDO POLIMORFISMO --");
        System.out.println("Array de " + figuras.length + " figuras:\n");
        
        // Polimorfismo: mismo método, diferentes comportamientos
        for (Figura figura : figuras) {
            // Llamada polimórfica - Java decide en tiempo de ejecución qué método ejecutar
            double area = figura.calcularArea();
            System.out.println("• " + figura.getNombre() + " - Area: " + area);
        }
        
        System.out.println("\n -- INSTANCEOF Y DOWNCASTING --");
        
        // USO DE INSTANCEOF para verificación de tipos
        int contadorCirculos = 0;
        int contadorRectangulos = 0;
        
        for (Figura figura : figuras) {
                if (figura instanceof Circulo) {
                contadorCirculos++;
                // Dowcasting seguro después de verificar con instanceof
                Circulo circulo = (Circulo) figura;
                System.out.println("Circulo: " + circulo.getNombre() + " - Radio: " + circulo.getRadio());
            } else if (figura instanceof Rectangulo) {
                contadorRectangulos++;
                // Dowcasting seguro después de verificar con instanceof
                Rectangulo rectangulo = (Rectangulo) figura;
                System.out.println("Rectangulo: " + rectangulo.getNombre() + " - Base: " + rectangulo.getBase() + 
                                 ", Altura: " + rectangulo.getAltura());
            }
        }
        

        // Calcular área total con reutilización de código implementando polimorfismo
        double areaTotal = 0;
        for (Figura figura : figuras) {
            areaTotal += figura.calcularArea(); // Reutilización mediante polimorfismo
        }
        System.out.println("Area total calculada polimorficamente: " + areaTotal);
    }
}