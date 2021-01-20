import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import java.io.File;
import java.sql.*;

public class InsertValueNeo4j {

    Driver driver = new ConexaoNeo4j().getConectarNeo4j();

    public void create() {
        Session session = driver.session();
        session.run("CREATE (n:Processo { IdProcesso: '23', NomeProcesso: 'Solitação de chamado' })");
        session.close();
        driver.close();

    }
}
