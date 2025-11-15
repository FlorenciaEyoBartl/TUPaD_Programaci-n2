
package trabajointegrador2;


/**
 * Clase utilitaria para mostrar el menú de la aplicación de gestión de pedidos y envíos.
 * Muestra opciones y submenús
 * Presenta enums de forma amigable
 */
public class MenuDisplay {
    
    public static void mostrarMenuPrincipal() {
        System.out.println("\n************ GESTION DE PEDIDOS Y ENVIOS **************");
        System.out.println("1. Crear pedido");
        System.out.println("2. Listar pedidos");
        System.out.println("3. Actualizar pedido");
        System.out.println("4. Eliminar pedido");
        System.out.println("5. Crear envio");
        System.out.println("6. Listar envios");
        System.out.println("7. Actualizar envio");
        System.out.println("8. Eliminar envio");
        System.out.println("9. Asignar envio a pedido");
        System.out.println("10. Eliminar envio de pedido");
        System.out.println("0. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    public static void mostrarMenuEstados() {
        System.out.println("\n-------- Estados de Pedido ------");
        System.out.println("1. NUEVO");
        System.out.println("2. FACTURADO"); 
        System.out.println("3. ENVIADO");
        System.out.print("Seleccione estado: ");
    }

    public static void mostrarMenuEmpresas() {
        System.out.println("\n----- Empresas de Envio -----");
        System.out.println("1. ANDREANI");
        System.out.println("2. OCA");
        System.out.println("3. CORREO_ARG");
        System.out.print("Seleccione empresa: ");
    }

    public static void mostrarMenuTiposEnvio() {
        System.out.println("\n----- Tipos de Envio -----");
        System.out.println("1. ESTANDAR");
        System.out.println("2. EXPRES");
        System.out.print("Seleccione tipo: ");
    }

    public static void mostrarMenuEstadosEnvio() {
        System.out.println("\n----- Estados de Envio -----");
        System.out.println("1. EN_PREPARACION");
        System.out.println("2. EN_TRANSITO");
        System.out.println("3. ENTREGADO");
        System.out.print("Seleccione estado: ");
    }
}