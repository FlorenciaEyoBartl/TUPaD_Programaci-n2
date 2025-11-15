package Dao;

import Config.DatabaseConnection;
import Model.Empresas;
import Model.Envio;
import Model.Estados;
import Model.EstadosEnvios;
import Model.Pedido;
import Model.Tipos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoDao implements GenericDao<Pedido>{
    
    // Consultas SQL 
    private static final String INSERT_SQL = "INSERT INTO pedidos (numero, fecha, cliente_nombre, total, estado, envio_id) VALUES (?, ?, ?, ?, ?, ?)";
    
    private static final String UPDATE_SQL = "UPDATE pedidos SET numero = ?, fecha = ?, cliente_nombre = ?, total = ?, estado = ?, envio_id = ? WHERE id = ?";
    
    private static final String DELETE_SQL = "UPDATE pedidos SET eliminado = TRUE WHERE id = ?";
    
    private static final String SELECT_BY_ID_SQL = "SELECT p.id, p.numero, p.fecha, p.cliente_nombre, p.total, p.estado, p.envio_id, " +
        "e.id AS env_id, e.tracking, e.empresa, e.tipo, e.costo, e.fecha_despacho, e.fecha_estimada, e.estado_envio " +
        "FROM pedidos p LEFT JOIN envios e ON p.envio_id = e.id " +
        "WHERE p.id = ? AND p.eliminado = FALSE";
    
    private static final String SELECT_ALL_SQL = "SELECT p.id, p.numero, p.fecha, p.cliente_nombre, p.total, p.estado, p.envio_id, " +
        "e.id AS env_id, e.tracking, e.empresa, e.tipo, e.costo, e.fecha_despacho, e.fecha_estimada, e.estado_envio " +
        "FROM pedidos p LEFT JOIN envios e ON p.envio_id = e.id " +
        "WHERE p.eliminado = FALSE";
    
    private static final String SEARCH_BY_NUMBER_SQL = "SELECT p.id, p.numero, p.fecha, p.cliente_nombre, p.total, p.estado, p.envio_id, " +
        "e.id AS env_id, e.tracking, e.empresa, e.tipo, e.costo, e.fecha_despacho, e.fecha_estimada, e.estado_envio " +
        "FROM pedidos p LEFT JOIN envios e ON p.envio_id = e.id " +
        "WHERE p.eliminado = FALSE AND p.numero = ?";
    
    private static final String SEARCH_BY_CLIENTE_NOMBRE_SQL = "SELECT p.id, p.numero, p.fecha, p.cliente_nombre, p.total, p.estado, p.envio_id, " +
        "e.id AS env_id, e.tracking, e.empresa, e.tipo, e.costo, e.fecha_despacho, e.fecha_estimada, e.estado_envio " +
        "FROM pedidos p LEFT JOIN envios e ON p.envio_id = e.id " +
        "WHERE p.eliminado = FALSE AND p.cliente_nombre LIKE ?";

    private final EnvioDao envioDAO;
    
    public PedidoDao(EnvioDao envioDao) {
        if (envioDao == null) {
            throw new IllegalArgumentException("EnvioDAO no puede ser null");
        }
        this.envioDAO = envioDao;
    }
    
    @Override
    public void insertar(Pedido pedido) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            setPedidoParameters(stmt, pedido);
            stmt.executeUpdate();
            setGeneratedId(stmt, pedido);
        }
    }
     // Método transaccional ------------
    @Override
    public void insertTx(Pedido pedido, Connection conn) throws Exception {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setPedidoParameters(stmt, pedido);
            stmt.executeUpdate();
            setGeneratedId(stmt, pedido);
        }
    }
    
    @Override
    public void actualizar(Pedido pedido) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL)) {
            
            setPedidoParameters(stmt, pedido);
            stmt.setLong(7, pedido.getId());  // ID va al final
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("No se pudo actualizar el pedido con ID: " + pedido.getId());
            }
        }
    }
        // MÉTODO TRANSACCIONAL para actualizar -----------
    public void actualizarTx(Pedido pedido, Connection conn) throws Exception {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL)) {
            setPedidoParameters(stmt, pedido);
            stmt.setLong(7, pedido.getId());
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("No se pudo actualizar el pedido con ID: " + pedido.getId());
            }
        }
    }
    @Override
    public void eliminar(long id) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(DELETE_SQL)) {

            stmt.setLong(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("No se encontro un pedido con ID: " + id);
            }
        }
    }
    
    private void setGeneratedId(PreparedStatement stmt, Pedido pedido) throws SQLException {
        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                pedido.setId(generatedKeys.getLong(1));  // Usar getLong para consistencia
            } else {
                throw new SQLException("La inserción del pedido fallo, no se obtuvo ID generado");
            }
        }
    }
    
    private void setPedidoParameters(PreparedStatement stmt, Pedido pedido) throws SQLException {
        stmt.setString(1, pedido.getNumero());
        stmt.setDate(2, java.sql.Date.valueOf(pedido.getFecha()));  // Usar Date.valueOf en lugar de Object
        stmt.setString(3, pedido.getClienteNombre());
        stmt.setDouble(4, pedido.getTotal());
        stmt.setString(5, pedido.getEstado().name());
        setEnvioId(stmt, 6, pedido.getEnvio());
    }
    
    private void setEnvioId(PreparedStatement stmt, int parameterIndex, Envio envio) throws SQLException {
        if (envio != null && envio.getId() > 0) {
            stmt.setLong(parameterIndex, envio.getId());
        } else {
            stmt.setNull(parameterIndex, Types.BIGINT);
        }
    }
    
    @Override
    public Pedido getById(long id) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToPedido(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener el pedido por ID: " + e.getMessage(), e);
        }
        return null;
    }
    
    private Pedido mapResultSetToPedido(ResultSet rs) throws SQLException {
        Pedido pedido = new Pedido();
        pedido.setId(rs.getLong("id"));
        pedido.setNumero(rs.getString("numero"));
        pedido.setFecha(rs.getDate("fecha").toLocalDate());
        pedido.setClienteNombre(rs.getString("cliente_nombre"));
        pedido.setTotal(rs.getDouble("total"));
        pedido.setEstado(Estados.valueOf(rs.getString("estado")));

        // Manejo correcto de LEFT JOIN
        long envioId = rs.getLong("envio_id");
        if (envioId > 0 && !rs.wasNull()) {
            Envio envio = new Envio();
            envio.setId(rs.getLong("env_id"));
            envio.setTracking(rs.getString("tracking"));
            envio.setEmpresa(Empresas.valueOf(rs.getString("empresa")));
            envio.setTipo(Tipos.valueOf(rs.getString("tipo")));
            envio.setCosto(rs.getDouble("costo"));
            
            // Manejo seguro de fechas
            java.sql.Date fechaDespacho = rs.getDate("fecha_despacho");
            if (fechaDespacho != null) {
                envio.setFechaDespacho(fechaDespacho.toLocalDate());
            }
            
            java.sql.Date fechaEstimada = rs.getDate("fecha_estimada");
            if (fechaEstimada != null) {
                envio.setFechaEstimada(fechaEstimada.toLocalDate());
            }
            
            envio.setEstadoEnvio(EstadosEnvios.valueOf(rs.getString("estado_envio")));
            pedido.setEnvio(envio);
        }
        return pedido;
    }

    public List<Pedido> buscarPorCliente(String filtro) throws SQLException {
        if (filtro == null || filtro.trim().isEmpty()) {
            throw new IllegalArgumentException("El filtro de busqueda no puede estar vacio");
        }

        List<Pedido> pedidos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SEARCH_BY_CLIENTE_NOMBRE_SQL)) {

            String searchPattern = "%" + filtro + "%";
            stmt.setString(1, searchPattern);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    pedidos.add(mapResultSetToPedido(rs));
                }
            }
        }
        return pedidos;
    }

    public Pedido buscarPorNumero(String numero) throws SQLException {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("El numero de pedido no puede estar vacío");
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SEARCH_BY_NUMBER_SQL)) {

            stmt.setString(1, numero.trim());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToPedido(rs);
                }
            }
        }
        return null;
    }
    
    @Override
    public List<Pedido> getAll() throws Exception {
        List<Pedido> pedidos = new ArrayList<>();
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL)) {
            
            while (rs.next()) {
                pedidos.add(mapResultSetToPedido(rs));
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener todos los pedidos: " + e.getMessage(), e);
        }
        return pedidos;
    }

    @Override
    public void recuperar(long id) throws Exception {
        // Implementación básica - puedes mejorarla luego
        throw new UnsupportedOperationException("Metodo recuperar no implementado aun");
    }
}