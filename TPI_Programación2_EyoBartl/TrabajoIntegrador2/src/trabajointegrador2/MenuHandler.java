package trabajointegrador2;

import Dao.PedidoDao;
import Model.*;
import Service.PedidoService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Controlador de las operaciones del menú para gestión de pedidos y envíos.
 * Implementa todas las funcionalidades del menú
 * Interactúa con el usuario via consola
 * Maneja entrada/salida y validaciones
 */
public class MenuHandler {
    private final Scanner scanner;
    private final PedidoService pedidoService;

    public MenuHandler(Scanner scanner, PedidoService pedidoService) {
        if (scanner == null) {
            throw new IllegalArgumentException("Scanner no puede ser null");
        }
        if (pedidoService == null) {
            throw new IllegalArgumentException("PedidoService no puede ser null");
        }
        this.scanner = scanner;
        this.pedidoService = pedidoService;
    }

    public void crearPedido() {
        try {
            System.out.print("Numero de pedido: ");
            String numero = scanner.nextLine().trim();
            System.out.print("Nombre del cliente: ");
            String clienteNombre = scanner.nextLine().trim();
            System.out.print("Total: ");
            double total = Double.parseDouble(scanner.nextLine());

            LocalDate fecha = LocalDate.now();
            
            Estados estado = seleccionarEstadoPedido();
            
            Envio envio = null;
            System.out.print("¿Desea crear un envio para este pedido? (s/n): ");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                envio = crearEnvioInteractivo();
            }

            Pedido pedido = new Pedido(numero, fecha, clienteNombre, total, estado, envio, 0, false);
            pedidoService.insertar(pedido);
            System.out.println("Pedido creado exitosamente con ID: " + pedido.getId());
            
        } catch (Exception e) {
            System.err.println("Error al crear pedido: " + e.getMessage());
        }
    }

    public void listarPedidos() {
        try {
            System.out.print("¿Desea (1) listar todos o (2) buscar por cliente? Ingrese opcion: ");
            int subopcion = Integer.parseInt(scanner.nextLine());

            List<Pedido> pedidos;
            if (subopcion == 1) {
                pedidos = pedidoService.getAll();
            } else if (subopcion == 2) {
                System.out.print("Ingrese nombre del cliente a buscar: ");
                String filtro = scanner.nextLine().trim();

                pedidos = pedidoService.getAll();
                pedidos = pedidos.stream()
                    .filter(p -> p.getClienteNombre().toLowerCase().contains(filtro.toLowerCase()))
                    .toList();
            } else {
                System.out.println("Opcion invalida.");
                return;
            }

            if (pedidos.isEmpty()) {
                System.out.println("No se encontraron pedidos.");
                return;
            }

            for (Pedido p : pedidos) {
                System.out.println("ID: " + p.getId() + ", Número: " + p.getNumero() +
                        ", Cliente: " + p.getClienteNombre() + ", Total: $" + p.getTotal() +
                        ", Estado: " + p.getEstado() + ", Fecha: " + p.getFecha());
                if (p.getEnvio() != null) {
                    System.out.println("   Envio: " + p.getEnvio().getTracking() + 
                            " - " + p.getEnvio().getEstadoEnvio());
                }
            }
        } catch (Exception e) {
            System.err.println("Error al listar pedidos: " + e.getMessage());
        }
    }

    public void actualizarPedido() {
        try {
            System.out.print("ID del pedido a actualizar: ");
            long id = Long.parseLong(scanner.nextLine());
            Pedido p = pedidoService.getById(id);

            if (p == null) {
                System.out.println("Pedido no encontrado.");
                return;
            }

            System.out.print("Nuevo numero (actual: " + p.getNumero() + ", Enter para mantener): ");
            String numero = scanner.nextLine().trim();
            if (!numero.isEmpty()) {
                p.setNumero(numero);
            }

            System.out.print("Nuevo nombre cliente (actual: " + p.getClienteNombre() + ", Enter para mantener): ");
            String clienteNombre = scanner.nextLine().trim();
            if (!clienteNombre.isEmpty()) {
                p.setClienteNombre(clienteNombre);
            }

            System.out.print("Nuevo total (actual: " + p.getTotal() + ", Enter para mantener): ");
            String totalStr = scanner.nextLine().trim();
            if (!totalStr.isEmpty()) {
                p.setTotal(Double.parseDouble(totalStr));
            }

            actualizarEnvioDePedido(p);
            pedidoService.actualizar(p);
            System.out.println("Pedido actualizado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al actualizar pedido: " + e.getMessage());
        }
    }

    public void eliminarPedido() {
        try {
            System.out.print("ID del pedido a eliminar: ");
            long id = Long.parseLong(scanner.nextLine());
            pedidoService.eliminar(id);
            System.out.println("Pedido eliminado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al eliminar pedido: " + e.getMessage());
        }
    }

    public void crearEnvio() {
        try {
            Envio envio = crearEnvioInteractivo();
            pedidoService.getEnvioService().insertar(envio);
            System.out.println("Envio creado exitosamente con ID: " + envio.getId());
        } catch (Exception e) {
            System.err.println("Error al crear envio: " + e.getMessage());
        }
    }

    public void listarEnvios() {
        try {
            List<Envio> envios = pedidoService.getEnvioService().getAll();
            if (envios.isEmpty()) {
                System.out.println("No se encontraron envios.");
                return;
            }
            for (Envio e : envios) {
                System.out.println("ID: " + e.getId() + ", Tracking: " + e.getTracking() +
                        ", Empresa: " + e.getEmpresa() + ", Tipo: " + e.getTipo() +
                        ", Costo: $" + e.getCosto() + ", Estado: " + e.getEstadoEnvio());
            }
        } catch (Exception e) {
            System.err.println("Error al listar envios: " + e.getMessage());
        }
    }

    public void actualizarEnvio() {
        try {
            System.out.print("ID del envio a actualizar: ");
            long id = Long.parseLong(scanner.nextLine());
            Envio e = pedidoService.getEnvioService().getById(id);

            if (e == null) {
                System.out.println("Envio no encontrado.");
                return;
            }

            System.out.print("Nuevo tracking (actual: " + e.getTracking() + ", Enter para mantener): ");
            String tracking = scanner.nextLine().trim();
            if (!tracking.isEmpty()) {
                e.setTracking(tracking);
            }

            System.out.print("Nuevo costo (actual: " + e.getCosto() + ", Enter para mantener): ");
            String costoStr = scanner.nextLine().trim();
            if (!costoStr.isEmpty()) {
                e.setCosto(Double.parseDouble(costoStr));
            }

            actualizarFechasEnvio(e);
            pedidoService.getEnvioService().actualizar(e);
            System.out.println("Envio actualizado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al actualizar envio: " + e.getMessage());
        }
    }

    public void eliminarEnvio() {
        try {
            System.out.print("ID del envío a eliminar: ");
            long id = Long.parseLong(scanner.nextLine());
            pedidoService.getEnvioService().eliminar(id);
            System.out.println("Envío eliminado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al eliminar envío: " + e.getMessage());
        }
    }

    public void asignarEnvioAPedido() {
        try {
            System.out.print("ID del pedido: ");
            long pedidoId = Long.parseLong(scanner.nextLine());
            System.out.print("ID del envio: ");
            long envioId = Long.parseLong(scanner.nextLine());

            Pedido pedido = pedidoService.getById(pedidoId);
            Envio envio = pedidoService.getEnvioService().getById(envioId);

            if (pedido == null || envio == null) {
                System.out.println("Pedido o envío no encontrado.");
                return;
            }

            pedido.setEnvio(envio);
            pedidoService.actualizar(pedido);
            System.out.println("Envio asignado al pedido exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al asignar envio: " + e.getMessage());
        }
    }

    public void eliminarEnvioDePedido() {
        try {
            System.out.print("ID del pedido: ");
            long pedidoId = Long.parseLong(scanner.nextLine());
            
            Pedido pedido = pedidoService.getById(pedidoId);
            if (pedido == null) {
                System.out.println("Pedido no encontrado.");
                return;
            }

            if (pedido.getEnvio() == null) {
                System.out.println("El pedido no tiene envio asociado.");
                return;
            }

            long envioId = pedido.getEnvio().getId();
            pedidoService.eliminarEnvioDePedido(pedidoId, envioId);
            System.out.println("Envio eliminado del pedido exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al eliminar envío del pedido: " + e.getMessage());
        }
    }

    private Envio crearEnvioInteractivo() {
        System.out.print("Numero de tracking: ");
        String tracking = scanner.nextLine().trim();
        System.out.print("Costo: ");
        double costo = Double.parseDouble(scanner.nextLine());

        Empresas empresa = seleccionarEmpresa();
        Tipos tipo = seleccionarTipoEnvio();
        EstadosEnvios estadoEnvio = seleccionarEstadoEnvio();

        Envio envio = new Envio(0, false, tracking, empresa, tipo, costo, null, null, estadoEnvio);
        
        System.out.print("¿Desea agregar fecha de despacho? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Fecha de despacho (YYYY-MM-DD): ");
            LocalDate fechaDespacho = LocalDate.parse(scanner.nextLine());
            envio.setFechaDespacho(fechaDespacho);
        }

        System.out.print("¿Desea agregar fecha estimada? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Fecha estimada (YYYY-MM-DD): ");
            LocalDate fechaEstimada = LocalDate.parse(scanner.nextLine());
            envio.setFechaEstimada(fechaEstimada);
        }

        return envio;
    }

    private Estados seleccionarEstadoPedido() {
        while (true) {
            try {
                MenuDisplay.mostrarMenuEstados();
                int opcion = Integer.parseInt(scanner.nextLine());
                return switch (opcion) {
                    case 1 -> Estados.NUEVO;
                    case 2 -> Estados.FACTURADO;
                    case 3 -> Estados.ENVIADO;
                    default -> {
                        System.out.println("Opcion inválida. Intente nuevamente.");
                        yield seleccionarEstadoPedido();
                    }
                };
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Intente nuevamente.");
            }
        }
    }

    private Empresas seleccionarEmpresa() {
        while (true) {
            try {
                MenuDisplay.mostrarMenuEmpresas();
                int opcion = Integer.parseInt(scanner.nextLine());
                return switch (opcion) {
                    case 1 -> Empresas.ANDREANI;
                    case 2 -> Empresas.OCA;
                    case 3 -> Empresas.CORREO_ARG;
                    default -> {
                        System.out.println("Opcion inválida. Intente nuevamente.");
                        yield seleccionarEmpresa();
                    }
                };
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Intente nuevamente.");
            }
        }
    }

    private Tipos seleccionarTipoEnvio() {
        while (true) {
            try {
                MenuDisplay.mostrarMenuTiposEnvio();
                int opcion = Integer.parseInt(scanner.nextLine());
                return switch (opcion) {
                    case 1 -> Tipos.ESTANDAR;
                    case 2 -> Tipos.EXPRES;
                    default -> {
                        System.out.println("Opción invalida. Intente nuevamente.");
                        yield seleccionarTipoEnvio();
                    }
                };
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Intente nuevamente.");
            }
        }
    }

    private EstadosEnvios seleccionarEstadoEnvio() {
        while (true) {
            try {
                MenuDisplay.mostrarMenuEstadosEnvio();
                int opcion = Integer.parseInt(scanner.nextLine());
                return switch (opcion) {
                    case 1 -> EstadosEnvios.EN_PREPARACION;
                    case 2 -> EstadosEnvios.EN_TRANSITO;
                    case 3 -> EstadosEnvios.ENTREGADO;
                    default -> {
                        System.out.println("Opcion invalida. Intente nuevamente.");
                        yield seleccionarEstadoEnvio();
                    }
                };
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Intente nuevamente.");
            }
        }
    }

    private void actualizarEnvioDePedido(Pedido p) throws Exception {
        if (p.getEnvio() != null) {
            System.out.print("¿Desea actualizar el envio? (s/n): ");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                actualizarFechasEnvio(p.getEnvio());
                pedidoService.getEnvioService().actualizar(p.getEnvio());
            }
        } else {
            System.out.print("El pedido no tiene envío. ¿Desea agregar uno? (s/n): ");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                Envio nuevoEnvio = crearEnvioInteractivo();
                pedidoService.getEnvioService().insertar(nuevoEnvio);
                p.setEnvio(nuevoEnvio);
            }
        }
    }

    private void actualizarFechasEnvio(Envio envio) {
        System.out.print("¿Actualizar fecha de despacho? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nueva fecha de despacho (YYYY-MM-DD): ");
            LocalDate fechaDespacho = LocalDate.parse(scanner.nextLine());
            envio.setFechaDespacho(fechaDespacho);
        }

        System.out.print("¿Actualizar fecha estimada? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nueva fecha estimada (YYYY-MM-DD): ");
            LocalDate fechaEstimada = LocalDate.parse(scanner.nextLine());
            envio.setFechaEstimada(fechaEstimada);
        }
    }
}