package testing.db;

import java.sql.*;
import java.sql.SQLException;

public class JDBCConnection {

    private Connection conn;

    public Connection getConexion() throws SQLException {
        try {
            conn = obtenerConexion();
        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException(e);
        }
        return conn;
    }

    public Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        String servidor = System.getenv("ENV_SERVER");
        String puerto = System.getenv("ENV_PORT");
        String db = System.getenv("ENV_DB");
        String usuario = System.getenv("ENV_USER");
        String clave = System.getenv("ENV_PASS");
//        String servidor = "localhost";
//        String puerto = "3306";
//        String db = "db_empleados_diplo";
//        String usuario = "root";
//        String clave = "";
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://" + servidor + ":" + puerto + "/" + db + "?user=" + usuario
                    + "&serverTimezone=UTC" + "&password=" + clave;

            conn = DriverManager.getConnection(connectionUrl);
            conn.setAutoCommit(false);

        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return conn;
    }

    public void close() throws Exception {
        try {
            if (null != conn) {
                // En realidad no cierra, solo libera la con.
                conn.close();
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
