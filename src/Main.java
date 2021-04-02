import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws Exception {
        //System.out.println(args[0]);
        String input;
        int op = 0;
        Scanner s = new Scanner(System.in);
        while (op != 9) {
            System.out.println("1 - Usa postgres");
            System.out.println("2 - Usa neo4j");
            System.out.println("9 - Fim");
            Scanner x = new Scanner(System.in);
            op = x.nextInt();

            ReadXML elemento = new ReadXML();
            //input = s.next();
            switch (op) {
                case 1:
                    System.out.println("Nome do Processo: ");
                    elemento.setName(s.next());
                    System.out.println("\nIdProcesso: ");
                    elemento.setId(s.nextInt());
                    System.out.println("\nArquivo: ");
                    elemento.setNameFile(s.next());
                    //InsertValuePGSQL c = new InsertValuePGSQL();
                    //c.insertProcess(elemento.getId(), elemento.getName());
                    ///ReadXML.lerXML("startEvent", elemento.getId(), elemento.getNameFile(), op);
                    lePostgres(elemento.getId(), elemento.getNameFile(), op);
                    break;
                case 2:
                    System.out.println("Nome do Processo: ");
                    elemento.setName(s.next());
                    System.out.println("\nIdProcesso: ");
                    elemento.setId(s.nextInt());
                    System.out.println("\nArquivo: ");
                    elemento.setNameFile(s.next());
                    leNeo4j(elemento.getId(), elemento.getNameFile(), op);
                    break;
            }
        }
    }


    public static void lePostgres(Integer Id, String Arquivo, Integer Op) throws Exception {

        ReadXML.lerXML("startEvent", Id, Arquivo, Op);
        ReadXML.lerXML("task", Id, Arquivo, Op);
        ReadXML.lerXML("exclusiveGateway",Id, Arquivo, Op);
        ReadXML.lerXML("endEvent", Id, Arquivo, Op);
        ReadXML.lerXML("sequenceFlow", Id, Arquivo, Op);
    }

    public static void leNeo4j(Integer Id, String Arquivo, Integer Op) throws Exception {

        ReadXML.lerXML("startEvent", Id, Arquivo, Op);
        ReadXML.lerXML("task", Id, Arquivo, Op);
        ReadXML.lerXML("exclusiveGateway",Id, Arquivo, Op);
        ReadXML.lerXML("endEvent", Id, Arquivo, Op);
        ReadXML.lerXML("sequenceFlow", Id, Arquivo, Op);
    }
}