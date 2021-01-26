import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;

public class InsertValueNeo4j {

    Driver driver = new ConnectionNeo4j().getConnection();

    public void insertTask(Integer idProcesso, String idElemento, String nomeElemento) {
        try {
            Session session = driver.session();
            session.run("CREATE (n:Element {IdElemento: '" + idElemento + "', NomeElemento: '" + nomeElemento + "', IdProcesso: '"+ idProcesso +"'})");
            session.close();
            //driver.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void relation(String idOrigem, String idDestino){
        Session session = driver.session();
        session.run("MATCH (n:Element), (n:Element) " +
                "WHERE a.IdProcesso= '"+idOrigem+"' AND b.IdOrigem='"+idDestino+"'" +
                "CREATE (n)-[f:INCOMING]->(n)");
        session.close();
        //driver.close();
    }
}
