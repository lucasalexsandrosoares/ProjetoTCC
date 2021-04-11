package tcc;

import org.neo4j.cypher.result.QueryResult;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

public class ReturnValueNeo4j {

    Driver driver = new ConnectionNeo4j().getConnection();

    public void returnElement() {

        Session session = driver.session();

        Result result = session.run(
                "MATCH (n) WHERE n.IdProcesso  = '1' RETURN  n.NomeElemento as NomeElemento, n.IdElemento as IdElemento");

        while ( result.hasNext() ) {
            Record record = result.next();
            System.out.println( record.get("NomeElemento" ).asString() +
                    ": " + record.get("IdElemento").asString() );
        }
    }

}
