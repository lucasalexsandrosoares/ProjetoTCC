import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;

public class ConexaoNeo4j {

    private String nome = "neo4j";
    private String senha = "070499";
    private String url = "bolt://localhost:7687";

    public Driver getConectarNeo4j() {
        try {
           return GraphDatabase.driver(url, AuthTokens.basic(nome, senha));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}