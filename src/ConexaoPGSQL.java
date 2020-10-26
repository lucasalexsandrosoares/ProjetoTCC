import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexaoPGSQL {

    private String nome = "postgres";
    private String senha = "070499";
    private String url = "jdbc:postgresql://localhost:5432/projetotcc";
    private Connection connection;
    private Statement statement;
    private String drive = "org.postgresql.Driver";


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

    public void insertElemet(String id, String tag){
        try {
            Class.forName(drive);
            connection = DriverManager.getConnection(url, nome, senha);
            statement = connection.createStatement();
            String query = "INSERT INTO \"Element\" (\"IdElement\", \"NameElement\", \"CodProcess\") values ('"+id+"','"+tag+"','1')";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Valor Inserido!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void insertFluxo(String idOrigem, String idDestino){
        try {
            Class.forName(drive);
            connection = DriverManager.getConnection(url, nome, senha);
            statement = connection.createStatement();
            String query = "INSERT INTO \"Flow\" (\"StructFrom\", \"StructTo\") values ('"+idOrigem+"','"+idDestino+"')";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Valor Inserido!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
