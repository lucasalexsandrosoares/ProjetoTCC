import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LerXML {

    public static void LerXML(String tag) throws SAXException,
            IOException, ParserConfigurationException {

        //Ler Arquivo
        File file = new File("D:\\Teste.bpmn");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);

        doc.getDocumentElement().normalize();

        NodeList startEvent = doc.getElementsByTagName(tag);

        for (int i = 0; i < startEvent.getLength(); i++) {

            Node nNode = startEvent.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                if(tag == "startEvent") {
                    String id = elem.getAttribute("id");
                    System.out.printf("EventoInicial: %s%n", id);
                }
                if(tag == "task"){
                    String id = elem.getAttribute("id");
                    System.out.printf("Tarefa: %s%n", id);
                }
                if(tag == "endEvent"){
                    String id = elem.getAttribute("id");
                    System.out.printf("EventoFinal: %s%n", id);
                }
                if(tag == "sequenceFlow"){
                    String sourceRef = elem.getAttribute("sourceRef");
                    String targetRef = elem.getAttribute("targetRef");
                    System.out.printf("AtividadeOrigem: %s%n", sourceRef);
                    System.out.printf("AtividadeDestino: %s%n", targetRef);
                }
            }
        }

    }
}