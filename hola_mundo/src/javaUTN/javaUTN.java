package javaUTN;
//@author Flo

import java.util.Scanner;

public class javaUTN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x , y ;
       System.out.print("Ingrese un número entero: ");
       x = Integer.parseInt(input.nextLine());
       
       System.out.print("Ingrese un número entero: ");
       y = Integer.parseInt(input.nextLine());
       int suma = x + y;
       int resta = x - y;
       int multiplicacion = x * y;
       double division = (double)x / y;
       System.out.println("La suma de los valores ingresados es: "+ suma);
       System.out.println("La resta de los valores ingresados es: "+ resta);
       System.out.println("La multiplicación de los valores ingresados es: "+ multiplicacion);
       System.out.println("La división entre los valores ingresados es: "+ division);
      
    }    
}
