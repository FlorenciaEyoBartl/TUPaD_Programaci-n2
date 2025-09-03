package utn_tp2_java;
import java.util.Scanner;
public class UTN_TP2_JAVA {
    
    // EJERCICIO 8 FUNCION PARA CALCULAR EL PRECIO
    public static double calcularPrecioFinal(double base, double impuesto, double descuento_) {
        return base + (base * impuesto) - (base * descuento_);
    }
    // EJERCICIO 9 FUNCIONES COSTO DE ENVIO Y TOTAL
    public static double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")) {
            return peso * 5;
        } else {
            return peso * 10;
        }
    }
    public static double calcularTotalCompra(double preciO, double costoEnvio){
        return preciO + costoEnvio;
    }
    // EJERCICIO 10 FUNCION DE ACTUALIZACION DE STOCK
    public static int actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida) {
        return stockActual - cantidadVendida + cantidadRecibida;
    }
    // EJERCICIO 11 DECLARACION DE VARIABLE GLOBAL Y FUNCION DESCUENTO
    static double descuentoGlobal = 0.10; // 10%
    public static void calcularDescuentoEspecial(double precIO) {
        double descuentoAplicado = precIO * descuentoGlobal;
        double precioFinal = precIO - descuentoAplicado;

        System.out.println("El descuento especial aplicado es: " + descuentoAplicado);
        System.out.println("El precio final con descuento es: " + precioFinal);
    }
    
    public static void main(String[] args) {
        
        //EJERCICIO 1
        System.out.println("EJERCICIO 1");
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese un año: ");
        int anio = input.nextInt();

        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            System.out.println(anio + " es un año bisiesto.");
        } else {
            System.out.println(anio + " no es un año bisiesto.");
        }
        //EJERCICIO 2
        System.out.println("EJERCICIO 2");
        System.out.print("Ingrese el primer número: ");
        int num1 = input.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int num2 = input.nextInt();

        System.out.print("Ingrese el tercer número: ");
        int num3 = input.nextInt();

        int mayor;

        if (num1 >= num2 && num1 >= num3) {
            mayor = num1;
        } else if (num2 >= num1 && num2 >= num3) {
            mayor = num2;
        } else {
            mayor = num3;
        }

        System.out.println("El mayor es: " + mayor);
        
        //EJERCICIO 3
        System.out.println("EJERCICIO 3");
        
        System.out.print("Ingrese su edad: ");
        int edad = input.nextInt();

        if (edad < 12) {
            System.out.println("Eres un Niño.");
        } else if (edad <= 17) {
            System.out.println("Eres un Adolescente.");
        } else if (edad <= 59) {
            System.out.println("Eres un Adulto.");
        } else {
            System.out.println("Eres un Adulto mayor.");
        }
        
        //EJERCICIO 4
        System.out.println("EJERCICIO 4");
        System.out.print("Ingrese el precio del producto: ");
        double precio = input.nextDouble();

        System.out.print("Ingrese la categoría del producto (A, B o C): ");
        char categoria = input.next().toUpperCase().charAt(0);

        double descuento = 0;

        switch (categoria) {
            case 'A' -> descuento = 0.10;
            case 'B' -> descuento = 0.15;
            case 'C' -> descuento = 0.20;
            default -> {
                System.out.println("Categoría inválida"); return;
            }
        }

        double precioFinal = precio - (precio * descuento);

        System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
        System.out.println("Precio final: " + precioFinal);
        
        //EJERCICIO 5
        System.out.println("EJERCICIO 5");
        int numero, suma = 0;

        while (true) {
            System.out.print("Ingrese un número (0 para terminar): ");
            numero = input.nextInt();

            if (numero == 0) {
                break;
            }

            if (numero % 2 == 0) {
                suma += numero;
            }
        }

        System.out.println("La suma de los números pares es: " + suma);
        
        //EJERCICIO 6
        System.out.println("EJERCICIO 6");
         int positivos = 0, negativos = 0, ceros = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int num = input.nextInt();

            if (num > 0) {
                positivos++;
            } else if (num < 0) {
                negativos++;
            } else {
                ceros++;
            }
        }

        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
        System.out.println("Ceros: " + ceros);
    
        
        //EJERCICIO 7
        System.out.println("EJERCICIO 7");
        int nota;

        do {
            System.out.print("Ingrese una nota (0-10): ");
            nota = input.nextInt();

            if (nota < 0 || nota > 10) {
                System.out.println("Error: Nota inválida.");
            }
        } while (nota < 0 || nota > 10);

        System.out.println("Nota guardada correctamente: " + nota);
    
        
        //EJERCICIO 8
        System.out.println("EJERCICIO 8");
         System.out.print("Ingrese el precio base del producto: ");
        double base = input.nextDouble();

        System.out.print("Ingrese el impuesto (%): ");
        double impuesto = input.nextDouble() / 100;

        System.out.print("Ingrese el descuento (%): ");
        double descuento_ = input.nextDouble() / 100;

        double resultado = calcularPrecioFinal(base, impuesto, descuento_);

        System.out.println("El precio final del producto es: " + resultado);
    
        
       
        
        //EJERCICIO 9
        System.out.println("EJERCICIO 9");
                System.out.print("Ingrese el precio del producto: ");
        double preciO = input.nextDouble();

        System.out.print("Ingrese el peso del paquete en kg: ");
        double peso = input.nextDouble();

        System.out.print("Ingrese la zona de envío (nacional/internacional): ");
        String zona = input.next();

        double costoEnvio = calcularCostoEnvio(peso, zona);
        double total = calcularTotalCompra(precio, costoEnvio);

        System.out.println("El costo de envío es: " + costoEnvio);
        System.out.println("El total a pagar es: " + total);
        
        
    //EJERCICIO 10
        System.out.println("EJERCICIO 10");
        
        System.out.print("Ingrese el stock actual del producto: ");
        int stock = input.nextInt();

        System.out.print("Ingrese la cantidad vendida: ");
        int vendida = input.nextInt();

        System.out.print("Ingrese la cantidad recibida: ");
        int recibida = input.nextInt();

        int nuevoStock = actualizarStock(stock, vendida, recibida);

        System.out.println("El nuevo stock del producto es: " + nuevoStock);
              
    //EJERCICIO 11
        System.out.println("EJERCICIO 11");
         System.out.print("Ingrese el precio del producto: ");
        double precIO = input.nextDouble();

        calcularDescuentoEspecial(precIO);
               
    //EJERCICIO 12
    // MODIFICACION DE ARRAYS
        System.out.println("EJERCICIO 12");
        double[] precioS = {199.99, 299.5, 149.75, 399.0, 89.99};

        System.out.println("Precios originales:");
        for (double p : precioS) {
            System.out.println("Precio: $" + p);
        }

        // Modificar un precio (el índice 2)
        precioS[2] = 129.99;

        System.out.println("\nPrecios modificados:");
        for (double p : precioS) {
            System.out.println("Precio: $" + p);
        }
                
    //EJERCICIO 13
        System.out.println("EJERCICIO 13");
    
    
    }
          
}    


