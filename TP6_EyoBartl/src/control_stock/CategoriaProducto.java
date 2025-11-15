
package control_stock;


public enum CategoriaProducto {
    ALIMENTOS("Productos comestibles"),
    ELECTRONICA("Dispositivos electrónicos"),
    ROPA("Prendas de vestir"),
    HOGAR("Artículos para el hogar");
    
    private final String description;
    
    CategoriaProducto(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}