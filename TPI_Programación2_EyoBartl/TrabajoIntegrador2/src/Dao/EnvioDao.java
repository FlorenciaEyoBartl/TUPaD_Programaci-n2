package Dao;

/**EnvioDao implementa la interfaz GenericDao<Envio>
Es utilizado por EnvioService
Es inyectado en PedidoDao a través del constructor
Finalmente es usado por PedidoService y MenuHandler
*/

import Config.DatabaseConnection;
import Model.Envio;
import Model.Empresas;
import Model.Tipos;
import Model.EstadosEnvios;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object para la entidad Envio.
 * Gestiona todas las operaciones de persistencia de envíos en la base de datos.
 *
 * Características:
 * - Implementa GenericDaoEnvio para operaciones CRUD estándar
 * - Usa PreparedStatements en TODAS las consultas (protección contra SQL injection)
 * - Implementa soft delete (eliminado=TRUE, no DELETE físico)
 * - Maneja conversión de Enums (Empresas, Tipos, EstadosEnvios)
 * - Soporta transacciones mediante insertTx() (recibe Connection externa)
 *
 * Patrón: DAO con try-with-resources para manejo automático de recursos JDBC
 */
public class EnvioDao implements GenericDao<Envio> {
    
    // Consulta para insertar en la base de datos un envío
    private static final String INSERT_SQL = "INSERT INTO envios (tracking, empresa, tipo, costo, fecha_despacho, fecha_estimada, estado_envio) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    // Consulta sql para modificar datos de la tabla, según el id
    private static final String UPDATE_SQL = "UPDATE envios SET tracking = ?, empresa = ?, tipo = ?, costo = ?, fecha_despacho = ?, fecha_estimada = ?, estado_envio = ? WHERE id = ?";
    
    // Borrado lógico seteando eliminado en TRUE, según su id
    private static final String DELETE_SQL = "UPDATE envios SET eliminado = TRUE WHERE id = ?";
    
    // Consulta select para obtener envíos por id
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM envios WHERE id = ? AND eliminado = FALSE";
    
    // Consulta para obtener todos los envíos activos
    private static final String SELECT_ALL_SQL = "SELECT * FROM envios WHERE eliminado = FALSE";
    
    // Consulta para buscar envío por tracking exacto
    private static final String SEARCH_BY_TRACKING_SQL = "SELECT * FROM envios WHERE tracking = ? AND eliminado = FALSE";
    
    // Consulta para recuperar un envío (soft delete reverso)
    private static final String RECOVER_SQL = "UPDATE envios SET eliminado = FALSE WHERE id = ?";

    /**
     * Inserta un envío en la base de datos (versión sin transacción).Crea su propia conexión y la cierra automáticamente.
     * Crea y cierra su propia conexión
     * Operación independiente - no forma parte de una transacción mayor
     * Auto-commit implícito (cada INSERT es una transacción separada)
     * Uso simple - no necesita coordinación externa
     * @param envio
     * @throws java.lang.Exception
     */
    @Override
    public void insertar(Envio envio) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            setEnvioParameters(stmt, envio);
            stmt.executeUpdate();
            setGeneratedId(stmt, envio);
        }
    }

    /**
     * Inserta un envío dentro de una transacción existente.NO crea nueva conexión.
     * recibe una Connection externa. NO cierra la conexión (responsabilidad del caller con TransactionManager)
     * Parte de una transacción mayor - múltiples operaciones atómicas
     * Control externo - el caller decide cuándo hacer commit/rollback. 
     * Mantiene la conexión abierta para operaciones posteriores
     * @param envio
     * @param conn
     * @throws java.lang.Exception
     */
    @Override //sobrescribiendo método de la interfaz GenericDao<Envio>.Ayuda al compilador a verificar que el método existe en la interfaz padre.
    public void insertTx(Envio envio, Connection conn) throws Exception {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setEnvioParameters(stmt, envio);
            stmt.executeUpdate();
            setGeneratedId(stmt, envio);
        }
    }

    /**
     * Actualiza un envío existente en la base de datos.Actualiza todos los campos del envío.
     * @param envio
     * @throws java.lang.Exception
     */
    @Override
    public void actualizar(Envio envio) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL)) {

            setEnvioParameters(stmt, envio);
            stmt.setLong(8, envio.getId()); // El ID va al final en UPDATE

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("No se pudo actualizar el envio con ID: " + envio.getId());
            }
        }
    }

    /**
     * Elimina lógicamente un envío (soft delete).Marca eliminado=TRUE sin borrar físicamente la fila.
     * @param id
     * @throws java.lang.Exception
     */
    @Override
    public void eliminar(long id) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_SQL)) {

            stmt.setLong(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("No se encontro envío con ID: " + id);
            }
        }
    }

    /**
     * Obtiene un envío por su ID.Solo retorna envíos activos (eliminado=FALSE).
     * @param id
     * @return 
     * @throws java.lang.Exception
     */
    @Override
    public Envio getById(long id) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEnvio(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener envío por ID: " + e.getMessage(), e);
        }
        return null;
    }

    /**
     * Obtiene todos los envíos activos (eliminado=FALSE).
     * @return 
     * @throws java.lang.Exception
     */
    @Override
    public List<Envio> getAll() throws Exception {
        List<Envio> envios = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL)) {

            while (rs.next()) {
                envios.add(mapResultSetToEnvio(rs));
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener todos los envios: " + e.getMessage(), e);
        }
        return envios;
    }

    /**
     * Recupera un envío que estaba eliminado lógicamente.Marca eliminado=FALSE para reactivar el envío.
     * @param id
     * @throws java.lang.Exception
     */
    @Override
    public void recuperar(long id) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(RECOVER_SQL)) {

            stmt.setLong(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("No se encontro envío con ID: " + id);
            }
        }
    }

    /**
     * Busca un envío por número de tracking exacto.Usado para validar unicidad del tracking.
     * @param tracking
     * @return 
     * @throws java.sql.SQLException
     */
    public Envio buscarPorTracking(String tracking) throws SQLException {
        if (tracking == null || tracking.trim().isEmpty()) {
            throw new IllegalArgumentException("El tracking no puede estar vacio");
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SEARCH_BY_TRACKING_SQL)) {

            stmt.setString(1, tracking.trim());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEnvio(rs);
                }
            }
        }
        return null;
    }

    /**
     * Setea los parámetros de envío en un PreparedStatement.
     * Método auxiliar usado por insertar() e insertTx().
     *
     * Parámetros seteados:
     * 1. tracking (String)
     * 2. empresa (String del Enum)
     * 3. tipo (String del Enum)
     * 4. costo (double)
     * 5. fecha_despacho (Date o NULL)
     * 6. fecha_estimada (Date o NULL)
     * 7. estado_envio (String del Enum)
     */
    private void setEnvioParameters(PreparedStatement stmt, Envio envio) throws SQLException {
        stmt.setString(1, envio.getTracking());
        stmt.setString(2, envio.getEmpresa().name());
        stmt.setString(3, envio.getTipo().name());
        stmt.setDouble(4, envio.getCosto());
        
        // Manejo de fechas NULL
        if (envio.getFechaDespacho() != null) {
            stmt.setDate(5, Date.valueOf(envio.getFechaDespacho()));
        } else {
            stmt.setNull(5, Types.DATE);
        }
        
        if (envio.getFechaEstimada() != null) {
            stmt.setDate(6, Date.valueOf(envio.getFechaEstimada()));
        } else {
            stmt.setNull(6, Types.DATE);
        }
        
        stmt.setString(7, envio.getEstadoEnvio().name());
    }

    /**
     * Obtiene el ID autogenerado por la BD después de un INSERT.
     * Asigna el ID generado al objeto envio.
     */
    private void setGeneratedId(PreparedStatement stmt, Envio envio) throws SQLException {
        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                envio.setId(generatedKeys.getLong(1)); // Usamos long como en tu Base class
            } else {
                throw new SQLException("La inserción del envío fallo, no se obtuvo ID generado");
            }
        }
    }

    /**
     * Mapea un ResultSet a un objeto Envio.
     * Reconstruye los Enums desde String.
     *
     * Mapeo de columnas:
     * - id - id (long)
     * - tracking - tracking
     * - empresa - Empresas Enum
     * - tipo - Tipos Enum
     * - costo - costo
     * - fecha_despacho - fechaDespacho (puede ser null)
     * - fecha_estimada - fechaEstimada (puede ser null)
     * - estado_envio - estadoEnvio Enum
     * - eliminado - eliminado
     */
    private Envio mapResultSetToEnvio(ResultSet rs) throws SQLException {
        Envio envio = new Envio();
        envio.setId(rs.getLong("id"));
        envio.setTracking(rs.getString("tracking"));
        envio.setEmpresa(Empresas.valueOf(rs.getString("empresa")));
        envio.setTipo(Tipos.valueOf(rs.getString("tipo")));
        envio.setCosto(rs.getDouble("costo"));
        envio.setEstadoEnvio(EstadosEnvios.valueOf(rs.getString("estado_envio")));
        envio.setEliminado(rs.getBoolean("eliminado"));
        
        // Manejo de fechas NULL
        Date fechaDespacho = rs.getDate("fecha_despacho");
        if (fechaDespacho != null && !rs.wasNull()) {
            envio.setFechaDespacho(fechaDespacho.toLocalDate());
        }
        
        Date fechaEstimada = rs.getDate("fecha_estimada");
        if (fechaEstimada != null && !rs.wasNull()) {
            envio.setFechaEstimada(fechaEstimada.toLocalDate());
        }

        return envio;
    }
}