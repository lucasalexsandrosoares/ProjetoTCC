package tcc;

import io.dropwizard.Application;
import io.dropwizard.logging.ExternalLoggingFactory;
import io.dropwizard.setup.Environment;

import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class TccApplication extends Application<TccConfiguration> {

    @Override
    public void run(TccConfiguration conf, Environment env) throws Exception {
        conf.setLoggingFactory(new ExternalLoggingFactory());
        env.jersey().register(new TccResource());
    }
    
    public static void main(String[] args) throws Exception {
        new TccApplication().run(args);
        TccResource c = new TccResource();

        ReadXML elemento = new ReadXML();

        int input;
        int op = 0;
        Scanner s = new Scanner(System.in);
        while (op != 9) {
            System.out.println("1 - Inserir postgres");
            System.out.println("2 - Inserir neo4j");
            System.out.println("3 - Retornar postgres");
            System.out.println("4 - Retornar neo4j");
            System.out.println("9 - Fim");
            Scanner x = new Scanner(System.in);
            op = x.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Nome do Processo: ");
                    elemento.setName(s.next());
                    System.out.println("\nIdProcesso: ");
                    elemento.setId(s.nextInt());
                    c.lePostgres(elemento.getName(),elemento.getId(), elemento.getName(), op);
                    break;
                case 2:
                    System.out.println("Nome do Processo: ");
                    elemento.setName(s.next());
                    System.out.println("\nIdProcesso: ");
                    elemento.setId(s.nextInt());
                    c.leNeo4j(elemento.getName(),elemento.getId(), elemento.getName(), op);
                    break;
                case 3:
                    ReturnValuePGSQL returnPG = new ReturnValuePGSQL();
                    System.out.println("IdProcesso: ");
                    input = s.nextInt();
                    returnPG.selectElement(input);
                    returnPG.selectFlow(input);
                    break;
                case 4:
                    ReturnValueNeo4j returnNeo4j = new ReturnValueNeo4j();
                    System.out.println("IdProcesso: ");
                    input = s.nextInt();
                    returnNeo4j.returnElement();
                    returnNeo4j.returnFlow();
                    break;
            }
        }
    }
}
