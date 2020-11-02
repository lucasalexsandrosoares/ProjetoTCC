import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertValuePGSQL {

    Connection con = new ConectarPGSQL().getConnection();

    public void insertProcess(Integer idProcesso, String nomeProcesso){
        try {
            String query = "INSERT INTO \"Processo\" (\"IdProcesso\",\"NomeProcesso\") values ('"+idProcesso+"','"+nomeProcesso+"')";
            PreparedStatement stmt  = con.prepareStatement(query);
            stmt.execute();
            System.out.println("Valor Inserido!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertElemet(String idElemento, String tag, Integer idProcesso){
        try {
            String query = "INSERT INTO \"Elemento\" (\"IdElemento\", \"NomeElemento\", \"IdProcesso\") values ('"+idElemento+"','"+tag+"','"+idProcesso+"')";
            PreparedStatement stmt  = con.prepareStatement(query);
            stmt.execute();
            System.out.println("Valor Inserido!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void insertFluxo(String idOrigem, String idDestino){
        try {
            String query = "INSERT INTO \"Fluxo\" (\"ElementoOrigem\", \"ElementoDestino\") values ('"+idOrigem+"','"+idDestino+"')";
            PreparedStatement stmt  = con.prepareStatement(query);
            stmt.execute();
            System.out.println("Valor Inserido!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
