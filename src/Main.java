import org.xml.sax.SAXException;
import java.util.Scanner;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

public class Main {
	
	public static void main(String args[]) throws SAXException,
    IOException, ParserConfigurationException{

		/*ReadXML elemento = new ReadXML();
		Scanner s = new Scanner(System.in);
		System.out.println("Nome do Processo: ");
		elemento.setName(s.nextLine());
		System.out.println("\nIdProcesso: ");
		elemento.setId(s.nextInt());

		InsertValuePGSQL c = new InsertValuePGSQL();
		c.insertProcess(elemento.getId(),elemento.getName());

		elemento.lerXML("startEvent", elemento.getId());
		elemento.lerXML("task", elemento.getId());
		elemento.lerXML("exclusiveGateway", elemento.getId());
		elemento.lerXML("endEvent", elemento.getId());
		elemento.lerXML("sequenceFlow", elemento.getId());*/

		//Conectar no Banco de dados Neo4j
	    //ConexaoNeo4j neo4j = new ConexaoNeo4j();
		InsertValueNeo4j neo4j = new InsertValueNeo4j();

		ReadXML elemento = new ReadXML();
		Scanner s = new Scanner(System.in);
		System.out.println("Nome do Processo: ");
		elemento.setName(s.nextLine());
		System.out.println("\nIdProcesso: ");
		elemento.setId(s.nextInt());
		elemento.lerXML("startEvent", elemento.getId());
		elemento.lerXML("task", elemento.getId());
		elemento.lerXML("exclusiveGateway", elemento.getId());
		elemento.lerXML("endEvent", elemento.getId());
		elemento.lerXML("sequenceFlow", elemento.getId());
	    }
}