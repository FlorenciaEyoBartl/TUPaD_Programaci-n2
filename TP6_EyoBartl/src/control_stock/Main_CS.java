
// Clic derecho en el editor → Run File (o Shift + F6)
package control_stock;


public class Main_CS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Crear inventario
        Inventario inventario = new Inventario();
        
        // 1. Crear al menos cinco productos
        Producto p1 = new Producto("001", "Arroz", 500, 100, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("002", "Laptop", 2500, 10, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("003", "Camisa", 800, 50, CategoriaProducto.ROPA);
        Producto p4 = new Producto("004", "Silla", 1200, 30, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("005", "Leche", 300, 80, CategoriaProducto.ALIMENTOS);
        
        // Agregar productos al inventario
        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);
        
        System.out.println("\n" + "=".repeat(50));
        
        // 2.Método lista todos los productos
        inventario.listarProductos();
        
        System.out.println("\n" + "=".repeat(50));
        
        // 3. Método busca producto por ID
        System.out.println("BUSCAR PRODUCTO POR ID:");
        Producto encontrado = inventario.buscarProductoPorId("002");
        if (encontrado != null) {
            encontrado.mostrarInfo();
        }
        
        System.out.println("\n" + "=".repeat(50));
        
        // 4. Método filtra por categoría
        inventario.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);
        
        System.out.println("\n" + "=".repeat(50));
        
        // 5. Método elimina producto y listar restantes
        inventario.eliminarProducto("003");
        inventario.listarProductos();
        
        System.out.println("\n" + "=".repeat(50));
        
        // 6. Método actualiza el stock
        inventario.actualizarStock("001", 150);
        
        System.out.println("\n" + "=".repeat(50));
        
        // 7. Método muestra total de stock
        System.out.println("TOTAL DE STOCK: " + inventario.obtenerTotalStock());
        
        System.out.println("\n" + "=".repeat(50));
        
        // 8. Método muestra el producto con mayor stock
        Producto mayorStock = inventario.obtenerProductoConMayorStock();
        if (mayorStock != null) {
            System.out.println("PRODUCTO CON MAYOR STOCK:");
            mayorStock.mostrarInfo();
        }
        
        System.out.println("\n" + "=".repeat(50));
        
        // 9. Método filtra productos por precio
        inventario.filtrarProductosPorPrecio(1000, 3000);
        
        System.out.println("\n" + "=".repeat(50));
        
        // 10. Método muestra categorías disponibles
        inventario.mostrarCategoriasDisponibles();
    }
}