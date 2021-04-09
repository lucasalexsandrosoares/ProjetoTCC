package tcc;

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

public class ReadXML {

    Integer id;
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void lerXML(String tag, Integer idProcesso)
            throws SAXException, IOException, ParserConfigurationException {

        // Ler Arquivo
        File file = new File("D:\\Abertura de Chamado.bpmn");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);

        doc.getDocumentElement().normalize();

        NodeList no = doc.getElementsByTagName(tag);

        for (int i = 0; i < no.getLength(); i++) {

            Node nNode = no.item(i);

            InsertValuePGSQL c = new InsertValuePGSQL();
            InsertValueNeo4j insertNeo4j = new InsertValueNeo4j();

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                if (tag == "startEvent") {
                    String idElemento = elem.getAttribute("id");
                    System.out.printf("EventoInicial: %s%n", idElemento);
                    // c.insertElemet(idElemento, tag, idProcesso);
                    insertNeo4j.insertStartEvent(idProcesso, idElemento, tag);

                }
                if (tag == "task") {
                    String idElemento = elem.getAttribute("id");
                    System.out.printf("Tarefa: %s%n", idElemento);
                    // c.insertElemet(idElemento, tag, idProcesso);
                    insertNeo4j.insertTask(idProcesso, idElemento, tag);
                }

                if (tag == "exclusiveGateway") {
                    String idElemento = elem.getAttribute("id");
                    System.out.printf("Gateway: %s%n", idElemento);
                    // c.insertElemet(idElemento, tag, idProcesso);
                    insertNeo4j.insertExclusiveGateway(idProcesso, idElemento, tag);
                }

                if (tag == "endEvent") {
                    String idElemento = elem.getAttribute("id");
                    System.out.printf("EventoFinal: %s%n", idElemento);
                    // c.insertElemet(idElemento, tag, idProcesso);
                    insertNeo4j.insertEndEvent(idProcesso, idElemento, tag);
                }
                if (tag == "sequenceFlow") {
                    String idOrigem = elem.getAttribute("sourceRef");
                    String idDestino = elem.getAttribute("targetRef");
                    System.out.printf("AtividadeOrigem: %s%n", idOrigem);
                    System.out.printf("AtividadeDestino: %s%n", idDestino);
                    // c.insertFluxo(idOrigem, idDestino);
                    insertNeo4j.relationship(idOrigem, idDestino);
                }
            }
        }

    }
}