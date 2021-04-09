package tcc;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;

public class InsertValueNeo4j {

    Driver driver = new ConnectionNeo4j().getConnection();

    public void insertStartEvent(Integer idProcesso, String idElemento, String nomeElemento) {
        try {
            Session session = driver.session();
            session.run("CREATE (n:StartEvent {IdElemento: '" + idElemento + "', NomeElemento: '" + nomeElemento + "', IdProcesso: '"+ idProcesso +"'})");
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertTask(Integer idProcesso, String idElemento, String nomeElemento) {
        try {
            Session session = driver.session();
            session.run("CREATE (n:Task {IdElemento: '" + idElemento + "', NomeElemento: '" + nomeElemento + "', IdProcesso: '"+ idProcesso +"'})");
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertExclusiveGateway(Integer idProcesso, String idElemento, String nomeElemento) {
        try {
            Session session = driver.session();
            session.run("CREATE (n:ExclusiveGateway {IdElemento: '" + idElemento + "', NomeElemento: '" + nomeElemento + "', IdProcesso: '"+ idProcesso +"'})");
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertEndEvent(Integer idProcesso, String idElemento, String nomeElemento) {
        try {
            Session session = driver.session();
            session.run("CREATE (n:EndEvent {IdElemento: '" + idElemento + "', NomeElemento: '" + nomeElemento + "', IdProcesso: '"+ idProcesso +"'})");
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void relationship(String idOrigem, String idDestino){
        Session session = driver.session();
        session.run("MATCH (a), (b)\n" +
                        "WHERE a.IdElemento= '"+ idOrigem +"' AND b.IdElemento='"+ idDestino +"'" +
                        "CREATE (a)-[r:INCOMING]->(b)\n" +
                        "RETURN a, r, b");
        session.close();
        //driver.close();
    }
}
