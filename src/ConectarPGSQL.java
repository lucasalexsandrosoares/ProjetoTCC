import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarPGSQL {

    private String nome = "postgres";
    private String senha = "070499";
    private String url = "jdbc:postgresql://localhost:5432/projetotcc";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    url, nome, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}