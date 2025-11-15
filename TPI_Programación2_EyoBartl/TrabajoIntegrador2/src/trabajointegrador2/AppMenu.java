
package trabajointegrador2;


import java.util.Scanner;
import Dao.EnvioDao;
import Dao.PedidoDao;
import Service.EnvioService;
import Service.PedidoService;

/**
 * Orquestador principal del menú de la aplicación de gestión de pedidos y envíos.
 * Gestiona el ciclo de vida del menú y coordina todas las dependencias.
 * Inicializa dependencias (DAO → Service)
 */
public class AppMenu {
    private final Scanner scanner;
    private final MenuHandler menuHandler;
    private boolean running;

    public AppMenu() {
        this.scanner = new Scanner(System.in);
        PedidoService pedidoService = createPedidoService();
        this.menuHandler = new MenuHandler(scanner, pedidoService);
        this.running = true;
    }

    public static void main(String[] args) {
        AppMenu app = new AppMenu();
        app.run();
    }

    public void run() {
        while (running) {
            try {
                MenuDisplay.mostrarMenuPrincipal();
                int opcion = Integer.parseInt(scanner.nextLine());
                processOption(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Por favor, ingrese un numero.");
            }
        }
        scanner.close();
    }

    private void processOption(int opcion) {
        switch (opcion) {
            case 1 -> menuHandler.crearPedido();
            case 2 -> menuHandler.listarPedidos();
            case 3 -> menuHandler.actualizarPedido();
            case 4 -> menuHandler.eliminarPedido();
            case 5 -> menuHandler.crearEnvio();
            case 6 -> menuHandler.listarEnvios();
            case 7 -> menuHandler.actualizarEnvio();
            case 8 -> menuHandler.eliminarEnvio();
            case 9 -> menuHandler.asignarEnvioAPedido();
            case 10 -> menuHandler.eliminarEnvioDePedido();
            case 0 -> {
                System.out.println("Saliendo...");
                running = false;
            }
            default -> System.out.println("Opcion no valida.");
        }
    }

    private PedidoService createPedidoService() {
        EnvioDao envioDao = new EnvioDao();
        PedidoDao pedidoDao = new PedidoDao(envioDao);
        EnvioService envioService = new EnvioService(envioDao);
        return new PedidoService(pedidoDao, envioService);
    }
}