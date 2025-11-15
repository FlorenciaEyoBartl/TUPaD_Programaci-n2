
package trabajointegrador2;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import Config.DatabaseConnection;

public class TestConexion {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Conexion exitosa a la base de datos");

                DatabaseMetaData metaData = conn.getMetaData();
                System.out.println("Usuario conectado: " + metaData.getUserName());
                System.out.println("Base de datos: " + conn.getCatalog());
                System.out.println("URL: " + metaData.getURL());
                System.out.println("Driver: " + metaData.getDriverName() + " v" + metaData.getDriverVersion());
                
                // Verificar tablas existentes
                System.out.println("\nTablas disponibles:");
                var tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
                while (tables.next()) {
                    System.out.println(" - " + tables.getString("TABLE_NAME"));
                }
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}