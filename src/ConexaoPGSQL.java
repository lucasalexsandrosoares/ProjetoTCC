import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoPGSQL {

    Connection c = null;
    String user;
    String senha;

    public void Conectar(String user, String senha){

        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetotcc", user, senha);
            System.out.println("Conexão realizada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }

}
