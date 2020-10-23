import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;


public class ConexaoNeo4j implements AutoCloseable
{
    private Driver driver;

    public void ConectarNeo4j(String user, String senha )
    {
        driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic( user, senha ) );
    }

    @Override
    public void close() throws Exception
    {
        driver.close();
    }
}