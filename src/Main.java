import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Transaction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

public class Main {
	
	public static void main(String args[]) throws SAXException,
    IOException, ParserConfigurationException{

		//Conectar no Banco de dados PostgreSQL
	    //ConexaoPGSQL postgresql = new ConexaoPGSQL();
		//postgresql.ConectarPostgresql("postgres", "070499");
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