
//Para correr cada clase principal precione click derecho y luego "Run File"
package ejercicio_3;


public class Principal3 {
    
     public static void main(String[] args) {
        System.out.println("EJERCICIO 3");
        
        //Crear Autor (asociación unidireccional)
        Autor autor = new Autor("Gabriel García Márquez", "Colombiana");
        
        //Crear Editorial (agregación)
        Editorial editorial = new Editorial("Sudamericana", "Buenos Aires 123");
        
        //Crear Libro con Autor y Editorial
        Libro libro = new Libro("Cien años de soledad", "978-8437604947", autor, editorial);
        
        //Demostrar relaciones
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Autor: " + libro.getAutor().getNombre() + 
                          " (" + libro.getAutor().getNacionalidad() + ")");
        System.out.println("Editorial: " + libro.getEditorial().getNombre());
        
        //Demostrar AGREGACIÓN (opción cambiar editorial)
        Editorial nuevaEditorial = new Editorial("Alfaguara", "Madrid 456");
        libro.setEditorial(nuevaEditorial);
        System.out.println("Nueva editorial: " + libro.getEditorial().getNombre());
    
    }
    
    
}
