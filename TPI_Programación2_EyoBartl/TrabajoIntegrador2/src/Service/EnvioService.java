package Service;

import Dao.EnvioDao;
import Dao.GenericDao;
import Model.Envio;
import java.util.List;

/**
 * Implementación del servicio de negocio para la entidad Envio.
 * Valida datos del envío antes de persistir
 * Verifica tracking único
 * Controla reglas de negocio
 */
public class EnvioService implements GenericService<Envio> {
    
    private final GenericDao<Envio> envioDao;

    public EnvioService(GenericDao<Envio> envioDao) {
        if (envioDao == null) {
            throw new IllegalArgumentException("EnvioDao no puede ser null");
        }
        this.envioDao = envioDao;
    }

    @Override
    public void insertar(Envio envio) throws Exception {
        validateEnvio(envio);
        envioDao.insertar(envio);
    }

    @Override
    public void actualizar(Envio envio) throws Exception {
        validateEnvio(envio);
        if (envio.getId() <= 0) {
            throw new IllegalArgumentException("El ID del envío debe ser mayor a 0 para actualizar");
        }
        envioDao.actualizar(envio);
    }

    @Override
    public void eliminar(long id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a 0");
        }
        envioDao.eliminar(id);
    }

    @Override
    public Envio getById(long id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a 0");
        }
        return envioDao.getById(id);
    }

    @Override
    public List<Envio> getAll() throws Exception {
        return envioDao.getAll();
    }
  
    public EnvioDao getEnvioDao() {
        return (EnvioDao) this.envioDao;
    }
    private void validateEnvio(Envio envio) {
        if (envio == null) {
            throw new IllegalArgumentException("El envio no puede ser null");
        }
        if (envio.getTracking() == null || envio.getTracking().trim().isEmpty()) {
            throw new IllegalArgumentException("El tracking no puede estar vacio");
        }
        if (envio.getEmpresa() == null) {
            throw new IllegalArgumentException("La empresa no puede estar vacia");
        }
        if (envio.getTipo() == null) {
            throw new IllegalArgumentException("El tipo no puede estar vacio");
        }
        if (envio.getEstadoEnvio() == null) {
            throw new IllegalArgumentException("El estado del envío no puede estar vacio");
        }
        if (envio.getCosto() < 0) {
            throw new IllegalArgumentException("El costo no puede ser negativo");
        }
    }
}