package Model;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author MATEO
 */
public class DatabaseConnection {

    private static final String SERVER = Config.SERVER;
    private static final int PORT = Config.PORT;
    private static final String DB = Config.DB;
    private static final String USER = Config.USER;
    private static final String PASSWORD = Config.PASSWORD;

    public static Connection getConnection() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName(SERVER);
        ds.setPortNumber(PORT);
        ds.setDatabaseName(DB);
        ds.setUser(USER);
        ds.setPassword(PASSWORD);

        try {
            Connection connection = ds.getConnection();
            return connection;
        }
        catch (SQLException e) {
            System.out.println("No se ha logrado la conexión a la base de datos.\n"
                    + "Verifique las credenciales en el archivo src/Model/Config.java");
        }
        return null;
    }
}
