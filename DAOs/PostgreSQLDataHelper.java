package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLDataHelper {
    private static final String URL = "jdbc:postgresql://localhost:5432/CineMax";
    private static final String USUARIO = "postgres";
    private static final String CONTRASENA = "1207";

    public static Connection conexion = null;

    public static Connection obtenerConexion() {
        try {
            // Cargar el controlador JDBC de PostgreSQL (requiere el .jar de PostgreSQL en tu proyecto)
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC de PostgreSQL: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
