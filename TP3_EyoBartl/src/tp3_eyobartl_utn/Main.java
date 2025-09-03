package tp3_eyobartl_utn;
public class Main {
    public static void main(String[] args) {    
    // ejercicio 1
    Estudiante estudiante1 = new Estudiante("Ana", "García", "Matemáticas", 7.5);
        estudiante1.mostrarInfo();
        estudiante1.subirCalificacion(1.5);
        estudiante1.bajarCalificacion(0.5);
        estudiante1.mostrarInfo();
        
    // ejercicio 2
    Mascota mascota1 = new Mascota("Max", "Perro", 3);
        mascota1.mostrarInfo();
        mascota1.cumplirAnios();
        mascota1.cumplirAnios();
        mascota1.mostrarInfo();
       
    // ejercicio 3
    Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967);
        libro1.mostrarInfo();
        libro1.setAñoPublicacion(3000);// Intentar modificar con valor inválido
        libro1.setAñoPublicacion(2020);// Modificar con valor válido
        libro1.mostrarInfo(); 
     
    // ejercicio 4
    Gallina gallina1 = new Gallina("G001", 3);
    Gallina gallina2 = new Gallina("G002", 0);
        gallina1.mostrarEstado();
        gallina2.mostrarEstado();
        gallina1.ponerHuevo();
        gallina2.ponerHuevo(); // No debería poder poner huevos
        gallina2.envejecer();
        gallina2.envejecer();
        gallina2.ponerHuevo(); // Ahora sí debería poder
        gallina1.mostrarEstado();
        gallina2.mostrarEstado();
   
    // ejercicio 5
     NaveEspacial nave1 = new NaveEspacial("Explorer-1", 50);
        nave1.mostrarEstado();
        nave1.despegar();
        // Intentar avanzar sin suficiente combustible
        nave1.avanzar(100);
        // Recargar combustible
        nave1.recargarCombustible(40);
        // Avanzar correctamente
        nave1.avanzar(50);
        nave1.mostrarEstado();       
}
}
