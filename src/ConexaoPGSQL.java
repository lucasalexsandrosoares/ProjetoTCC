import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexaoPGSQL {

    Connection connection = null;
    Statement statement = null;

    public void ConectarPostgresql(String user, String senha){

        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetotcc", user, senha);
            System.out.println("Conexão realizada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }

    public void insertProcess(){
        try {
            String query = "INSERT INTO \"Process\" (\"CodProcess\",\"NameProcess\") values ('1','Teste')";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Valor Inserido!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void insertElemet(String id, String name){
        try {
            String query = "INSERT INTO \"Process\" (\"CodProcess\",\"NameProcess\") values ('1','Teste')";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Valor Inserido!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
