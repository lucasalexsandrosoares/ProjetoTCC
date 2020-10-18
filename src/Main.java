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

	    ConexaoPGSQL conectar = new ConexaoPGSQL();
	    conectar.Conectar("postgres", "070499");

		//Conectar no Banco de dados
		/*Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "070499"));

		//Ler Arquivo
		File fXmlFile = new File("D:\\Teste.bpmn");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        doc.getDocumentElement().normalize();

        NodeList startEvent = doc.getElementsByTagName("startEvent");
        
        for (int i = 0; i < startEvent.getLength(); i++) {

            Node nNode = startEvent.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                String id = elem.getAttribute("id");
                
                System.out.printf("EventoInicial: %s%n", id);
                
                
            }
        }
        
        NodeList task = doc.getElementsByTagName("task");
        
        for (int i = 0; i < task.getLength(); i++) {

            Node nNode = task.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                String id = elem.getAttribute("id");
                
                System.out.printf("Tarefa: %s%n", id);

            }
        }
        
        NodeList endEvent = doc.getElementsByTagName("endEvent");
        
        for (int i = 0; i < endEvent.getLength(); i++) {

            Node nNode = endEvent.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                String id = elem.getAttribute("id");
                
                System.out.printf("EventoFinal: %s%n", id);

            }
        }
        
        NodeList sequenceFlow = doc.getElementsByTagName("sequenceFlow");
        
        for (int i = 0; i < sequenceFlow.getLength(); i++) {

            Node nNode = sequenceFlow.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                String id = elem.getAttribute("id");
                String sourceRef = elem.getAttribute("sourceRef");
                String targetRef = elem.getAttribute("targetRef");
                
                System.out.printf("idFlow: %s%n", id);
                System.out.printf("AtividadeOrigem: %s%n", sourceRef);
                System.out.printf("AtividadeDestino: %s%n", targetRef);
                
                
                
            }
            
        }
        driver.close();
    */}
}