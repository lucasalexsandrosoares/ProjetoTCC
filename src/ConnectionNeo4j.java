import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;

public class ConnectionNeo4j {

    private String name = "neo4j";
    private String password = "070499";
    private String url = "bolt://localhost:7687";

    public Driver getConnection() {
        try {
           return GraphDatabase.driver(url, AuthTokens.basic(name, password));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}