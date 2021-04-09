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
    }
}
