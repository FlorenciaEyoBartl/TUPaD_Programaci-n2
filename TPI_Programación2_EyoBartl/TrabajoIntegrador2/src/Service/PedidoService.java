package Service;

import Dao.PedidoDao;
import Model.Pedido;
import Model.Envio;
import Model.Estados;
import Config.TransactionManager;
import Config.DatabaseConnection;
import Dao.EnvioDao;
import java.util.List;

/**
 * Implementación del servicio de negocio para la entidad Pedido.
 * Coordina creación/actualización de pedidos y envíos
 * Valida unicidad del número de pedido
 * Maneja la relación pedido-envío
 */
public class PedidoService implements GenericService<Pedido> {
    
    private final PedidoDao pedidoDao;
    private final EnvioService envioService;

    public PedidoService(PedidoDao pedidoDao, EnvioService envioService) {
        if (pedidoDao == null) {
            throw new IllegalArgumentException("PedidoDao no puede ser null");
        }
        if (envioService == null) {
            throw new IllegalArgumentException("EnvioService no puede ser null");
        }
        this.pedidoDao = pedidoDao;
        this.envioService = envioService;
    }

    @Override
    public void insertar(Pedido pedido) throws Exception {
        validatePedido(pedido);
        validateNumeroUnique(pedido.getNumero(), null);

        //Usar TransactionManager para garantizar "TODO O NADA"
        try (TransactionManager tx = new TransactionManager(DatabaseConnection.getConnection())) {
            tx.startTransaction();
            
            // Si el pedido tiene un envío NUEVO (id = 0), lo insertamos en la MISMA transacción
            if (pedido.getEnvio() != null && pedido.getEnvio().getId() == 0) {
                envioService.getEnvioDao().insertTx(pedido.getEnvio(), tx.getConnection());
            }
            
            // Insertamos el pedido en la MISMA transacción
            pedidoDao.insertTx(pedido, tx.getConnection());
            
            //Si llegamos aquí, TODO funcionó - confirmamos la transacción
            tx.commit();
            System.out.println(" Pedido guardado exitosamente" + 
                (pedido.getEnvio() != null ? " con su envío asociado" : ""));
            
        } catch (Exception e) {
            // Si algo falla, la transacción se revierte AUTOMÁTICAMENTE
            throw new Exception("Error al guardar pedido: " + e.getMessage() + 
                " - No se guardó ningún dato en la base de datos");
        }
    }


    @Override
    public void actualizar(Pedido pedido) throws Exception {
        validatePedido(pedido);
        if (pedido.getId() <= 0) {
            throw new IllegalArgumentException("El ID del pedido debe ser mayor a 0 para actualizar");
        }
        
        validateNumeroUnique(pedido.getNumero(), pedido.getId());

        try (TransactionManager tx = new TransactionManager(DatabaseConnection.getConnection())) {
            tx.startTransaction();
            
            // Si tiene un envío NUEVO, lo insertamos en la transacción
            if (pedido.getEnvio() != null && pedido.getEnvio().getId() == 0) {
                envioService.getEnvioDao().insertTx(pedido.getEnvio(), tx.getConnection());
            }
            
            // Actualizamos el pedido en la MISMA transacción
            pedidoDao.actualizarTx(pedido, tx.getConnection());
            
            tx.commit();
            System.out.println(" Pedido actualizado exitosamente");
            
        } catch (Exception e) {
            throw new Exception("Error al actualizar pedido: " + e.getMessage() + 
                " - Los cambios no fueron guardados");
        }
    }
    

    @Override
    public void eliminar(long id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a 0");
        }
        pedidoDao.eliminar(id);
    }

    @Override
    public Pedido getById(long id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a 0");
        }
        return pedidoDao.getById(id);
    }

    @Override
    public List<Pedido> getAll() throws Exception {
        return pedidoDao.getAll();
    }

    public EnvioService getEnvioService() {
        return this.envioService;
    }
    
        
    public EnvioDao getEnvioDao() {
        return this.envioService.getEnvioDao();
    }

    
    
    public List<Pedido> buscarPorCliente(String filtro) throws Exception {
        if (filtro == null || filtro.trim().isEmpty()) {
            throw new IllegalArgumentException("El filtro de busqueda no puede estar vacio");
        }
        return pedidoDao.buscarPorCliente(filtro);
    }
    
 
    
    public Pedido buscarPorNumero(String numero) throws Exception {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("El numero no puede estar vacío");
        }
        return pedidoDao.buscarPorNumero(numero);
    }
    
    
    public void eliminarEnvioDePedido(long pedidoId, long envioId) throws Exception {
        if (pedidoId <= 0 || envioId <= 0) {
            throw new IllegalArgumentException("Los IDs deben ser mayores a 0");
        }

        Pedido pedido = pedidoDao.getById(pedidoId);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido no encontrado con ID: " + pedidoId);
        }

        if (pedido.getEnvio() == null || pedido.getEnvio().getId() != envioId) {
            throw new IllegalArgumentException("El envio no pertenece a este pedido");
        }

        
        try (TransactionManager tx = new TransactionManager(DatabaseConnection.getConnection())) {
            tx.startTransaction();
            
            // 1. Quitar el envío del pedido
            pedido.setEnvio(null);
            pedidoDao.actualizarTx(pedido, tx.getConnection());
            
            // 2. Eliminar el envío
            envioService.getEnvioDao().eliminar(envioId);
            
            tx.commit();
            System.out.println(" Envio eliminado del pedido exitosamente");
            
        } catch (Exception e) {
            throw new Exception("Error al eliminar envío del pedido: " + e.getMessage());
        }
    }
   
    // MÉTODOS DE VALIDACIÓN
    private void validatePedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser null");
        }
        if (pedido.getNumero() == null || pedido.getNumero().trim().isEmpty()) {
            throw new IllegalArgumentException("El numero de pedido no puede estar vacio");
        }
        if (pedido.getClienteNombre() == null || pedido.getClienteNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacio");
        }
        if (pedido.getTotal() < 0) {
            throw new IllegalArgumentException("El total no puede ser negativo");
        }
        if (pedido.getFecha() == null) {
            throw new IllegalArgumentException("La fecha no puede estar vacia");
        }
        if (pedido.getEstado() == null) {
            throw new IllegalArgumentException("El estado no puede estar vacio");
        }
    }

    //Usa Long (wrapper) en lugar de long (primitivo)
    private void validateNumeroUnique(String numero, Long pedidoId) throws Exception {

        if (pedidoId == null) {
            // Es una inserción nueva, verificar que no exista
            Pedido existente = pedidoDao.buscarPorNumero(numero);
            if (existente != null) {
                throw new IllegalArgumentException("Ya existe un pedido con el numero: " + numero);
            }
        } else {
            // Es una actualización, verificar que no exista otro pedido con el mismo número
            Pedido existente = pedidoDao.buscarPorNumero(numero);
            if (existente != null && existente.getId() != pedidoId) {
                throw new IllegalArgumentException("Ya existe otro pedido con el numero: " + numero);
            }
        }
   
    }
}