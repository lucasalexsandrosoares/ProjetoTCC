package tcc;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/tcc")
@Produces(MediaType.TEXT_PLAIN)
public class TccResource {
    private static final Logger log = LoggerFactory.getLogger(TccResource.class);

    @Path("postgres")
    public String lePostgres(@QueryParam("processo") String processo, @QueryParam("id") Integer id) throws Exception {
        log.info("lePostgres({}, {})", processo, id);
        ReadXML elemento = new ReadXML();
        elemento.setName(processo);
        System.out.println("\nIdProcesso: ");
        elemento.setId(id);

        InsertValuePGSQL c = new InsertValuePGSQL();
        c.insertProcess(elemento.getId(), elemento.getName());

        ReadXML.lerXML("startEvent", elemento.getId());
        ReadXML.lerXML("task", elemento.getId());
        ReadXML.lerXML("exclusiveGateway", elemento.getId());
        ReadXML.lerXML("endEvent", elemento.getId());
        ReadXML.lerXML("sequenceFlow", elemento.getId());
        return "ok";
    }

    @Path("neo4j")
    public String leNeo4j(@QueryParam("processo") String processo, @QueryParam("id") Integer id) throws Exception {
        // Conectar no Banco de dados Neo4j
        // ConexaoNeo4j neo4j = new ConexaoNeo4j();
        // InsertValueNeo4j neo4j = new InsertValueNeo4j();

        ReadXML elemento = new ReadXML();
        elemento.setName(processo);
        System.out.println("\nIdProcesso: ");
        elemento.setId(id);
        ReadXML.lerXML("startEvent", elemento.getId());
        ReadXML.lerXML("task", elemento.getId());
        ReadXML.lerXML("exclusiveGateway", elemento.getId());
        ReadXML.lerXML("endEvent", elemento.getId());
        ReadXML.lerXML("sequenceFlow", elemento.getId());
        return "ok";
    }
}
