import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPGSQL {

    private String name = "postgres";
    private String password = "070499";
    private String url = "jdbc:postgresql://localhost:5432/projetotcc";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    url, name, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}