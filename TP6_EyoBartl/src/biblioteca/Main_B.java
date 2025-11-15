package biblioteca;

public class Main_B {
    public static void main(String[] args) {
        System.out.println("** BIBLIOTECA ***");
        
        // Crear una biblioteca
        Biblioteca biblioteca = new Biblioteca("biblioteca central");
        
        // Crear tres autores
        Autor autor1 = new Autor("A001", "Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("A002", "Jorge Luis Borges", "Argentina");
        Autor autor3 = new Autor("A003", "Isabel Allende", "Chilena");
        Autor autor4 = new Autor("A004", "Mario Vargas Llosa", "Peruana");
        
        // Agregar 5 libros asociados a autores
        biblioteca.agregarLibro("9788437604947", "Cien años de soledad", 1967, autor1);
        biblioteca.agregarLibro("9788478884458", "El amor en los tiempos del cólera", 1985, autor1);
        biblioteca.agregarLibro("9789507315951", "Ficciones", 1944, autor2);
        biblioteca.agregarLibro("9788401337201", "La casa de los espíritus", 1982, autor3);
        biblioteca.agregarLibro("9788432218423", "La ciudad y los perros", 1963, autor4);
        
        System.out.println("\n" + "=".repeat(50));
        
        // Listar todos los libros con su información
        biblioteca.listarLibros();
        
        System.out.println("\n" + "=".repeat(50));
        
        // Buscar un libro por ISBN
        System.out.println("BUSCAR LIBRO POR ISBN:");
        Libro libroEncontrado = biblioteca.buscarLibroPorIsbn("9788437604947");
        if (libroEncontrado != null) {
            libroEncontrado.mostrarInfo();
        }
        
        System.out.println("\n" + "=".repeat(50));
        
        // Filtrar libros por año
        biblioteca.filtrarLibrosPorAnio(1985);
        
        System.out.println("\n" + "=".repeat(50));
        
        // Eliminar un libro y listar restantes
        biblioteca.eliminarLibro("9789507315951");
        biblioteca.listarLibros();
        
        System.out.println("\n" + "=".repeat(50));
        
        // Mostrar cantidad total de libros
        System.out.println("CANTIDAD TOTAL DE LIBROS: " + biblioteca.obtenerCantidadLibros());
        
        System.out.println("\n" + "=".repeat(50));
        
        // Listar todos los autores disponibles
        biblioteca.mostrarAutoresDisponibles();
        
        // Prueba adicional: filtrar por otro año
        System.out.println("\n" + "=".repeat(50));
        biblioteca.filtrarLibrosPorAnio(1967);
    }
}