package tcc;

import io.dropwizard.Application;
import io.dropwizard.logging.ExternalLoggingFactory;
import io.dropwizard.setup.Environment;

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
        ReturnValuePGSQL p = new ReturnValuePGSQL();
        p.consultElement();
        ReturnValueNeo4j e = new ReturnValueNeo4j();
        e.returnElement();
        /*
        ReadXML elemento = new ReadXML();
        int op = 0;
        Scanner s = new Scanner(System.in);
        while (op != 9) {
            System.out.println("1 - Usa postgres");
            System.out.println("2 - Usa neo4j");
            System.out.println("9 - Fim");
            Scanner x = new Scanner(System.in);
            op = x.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Nome do Processo: ");
                    elemento.setName(s.next());
                    System.out.println("\nIdProcesso: ");
                    elemento.setId(s.nextInt());
                    c.lePostgres(elemento.getName(),elemento.getId());
                    break;
                case 2:
                    //leNeo4j();
                    break;
            }
        }*/
    }
}
