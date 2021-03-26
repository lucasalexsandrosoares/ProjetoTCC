import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws Exception {
        int op = 0;
        while (op != 9) {
            System.out.println("1 - Usa postgres");
            System.out.println("2 - Usa neo4j");
            System.out.println("9 - Fim");
            Scanner x = new Scanner(System.in);
            op = x.nextInt();
            x.close();
            switch (op) {
                case 1:
                    lePostgres();
                    break;
                case 2:
                    leNeo4j();
                    break;
            }
        }
    }

    public static void lePostgres() throws Exception {

        ReadXML elemento = new ReadXML();
        Scanner s = new Scanner(System.in);
        System.out.println("Nome do Processo: ");
        elemento.setName(s.nextLine());
        System.out.println("\nIdProcesso: ");
        elemento.setId(s.nextInt());
        s.close();

        InsertValuePGSQL c = new InsertValuePGSQL();
        c.insertProcess(elemento.getId(), elemento.getName());

        ReadXML.lerXML("startEvent", elemento.getId());
        ReadXML.lerXML("task", elemento.getId());
        ReadXML.lerXML("exclusiveGateway", elemento.getId());
        ReadXML.lerXML("endEvent", elemento.getId());
        ReadXML.lerXML("sequenceFlow", elemento.getId());
    }

    public static void leNeo4j() throws Exception {
        // Conectar no Banco de dados Neo4j
        // ConexaoNeo4j neo4j = new ConexaoNeo4j();
        // InsertValueNeo4j neo4j = new InsertValueNeo4j();

        ReadXML elemento = new ReadXML();
        Scanner s = new Scanner(System.in);
        System.out.println("Nome do Processo: ");
        elemento.setName(s.nextLine());
        System.out.println("\nIdProcesso: ");
        elemento.setId(s.nextInt());
        s.close();
        ReadXML.lerXML("startEvent", elemento.getId());
        ReadXML.lerXML("task", elemento.getId());
        ReadXML.lerXML("exclusiveGateway", elemento.getId());
        ReadXML.lerXML("endEvent", elemento.getId());
        ReadXML.lerXML("sequenceFlow", elemento.getId());
    }
}