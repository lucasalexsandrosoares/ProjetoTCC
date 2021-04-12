package tcc;

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

    public void returnFlow() {

        Session session = driver.session();

        Result result = session.run(
                "MATCH (n)-[r]-(m) RETURN n.NomeElemento + ': '+n.IdElemento as ElemetoOrigem, type(r), m.NomeElemento + ': ' + m.IdElemento as ElementoDestino;");

        while ( result.hasNext() ) {
            Record record = result.next();
            System.out.println( record.get("ElemetoOrigem" ).asString() +
                    " -> " + record.get("ElementoDestino").asString() );
        }
    }
}
