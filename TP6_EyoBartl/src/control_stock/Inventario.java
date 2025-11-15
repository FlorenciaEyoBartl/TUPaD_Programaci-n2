
package control_stock;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;
    
    public Inventario() {
        this.productos = new ArrayList<>();
    }
    
    // 1. Método agrega producto
    public void agregarProducto(Producto p) {
        productos.add(p);
        System.out.println("Producto agregado: " + p.getNombre());
    }
    
    // 2. Método lista todos los productos
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }
        
        System.out.println("LISTA DE PRODUCTOS");
        for (Producto p : productos) {
            p.mostrarInfo();
        }
    }
    
    // 3. Método busca producto por ID
    public Producto buscarProductoPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null; // No encontrado
    }
    
    // 4. Método elimina producto por ID
    public boolean eliminarProducto(String id) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            productos.remove(p);
            System.out.println("Producto eliminado: " + p.getNombre());
            return true;
        }
        System.out.println("No se encontró producto con ID: " + id);
        return false;
    }
    
    // 5. Método actualiza stock
    public boolean actualizarStock(String id, int nuevaCantidad) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            p.setCantidad(nuevaCantidad);
            System.out.println("Stock actualizado para " + p.getNombre() + ": " + nuevaCantidad);
            return true;
        }
        System.out.println("No se encontró producto con ID: " + id);
        return false;
    }
    
    // 6. Método filtra por categoría
    public void filtrarPorCategoria(CategoriaProducto categoria) {
        System.out.println(" PRODUCTOS DE CATEGORÍA: " + categoria);
        boolean encontrado = false;
        
        for (Producto p : productos) {
            if (p.getCategoria() == categoria) {
                p.mostrarInfo();
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("No hay productos en la categoría: " + categoria);
        }
    }
    
    // 7. Método obtiene el total de stock
    public int obtenerTotalStock() {
        int total = 0;
        for (Producto p : productos) {
            total += p.getCantidad();
        }
        return total;
    }
    
    // 8. Método Obtiene producto con mayor stock
    public Producto obtenerProductoConMayorStock() {
        if (productos.isEmpty()) return null;
        
        Producto mayorStock = productos.get(0);
        for (Producto p : productos) {
            if (p.getCantidad() > mayorStock.getCantidad()) {
                mayorStock = p;
            }
        }
        return mayorStock;
    }
    
    // 9. Método filtra productos por precio
    public void filtrarProductosPorPrecio(double min, double max) {
        System.out.println("PRODUCTOS ENTRE $" + min + " Y $" + max );
        boolean encontrado = false;
        
        for (Producto p : productos) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                p.mostrarInfo();
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("No hay productos en ese rango de precio.");
        }
    }
    
    // 10. Método muestra categorías disponibles
    public void mostrarCategoriasDisponibles() {
        System.out.println(" CATEGORÍAS DISPONIBLES ");
        for (CategoriaProducto categoria : CategoriaProducto.values()) {
            System.out.println("- " + categoria + ": " + categoria.getDescription());
        }
    }
}