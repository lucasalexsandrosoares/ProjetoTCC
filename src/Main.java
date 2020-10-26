import org.xml.sax.SAXException;


import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

public class Main {
	
	public static void main(String args[]) throws SAXException,
    IOException, ParserConfigurationException{

		//Conectar no Banco de dados PostgreSQL
		//postgresql.insertProcess();
		LerXML elemento = new LerXML();
		elemento.LerXML("startEvent");
		elemento.LerXML("task");
		elemento.LerXML("endEvent");
		elemento.LerXML("sequenceFlow");

		//Conectar no Banco de dados Neo4j
	    //ConexaoNeo4j neo4j = new ConexaoNeo4j();
	    //neo4j.ConectarNeo4j("neo4j", "070499");

	    }
}