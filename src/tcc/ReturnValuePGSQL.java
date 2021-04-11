package tcc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReturnValuePGSQL {

    Connection connection = new ConnectionPGSQL().getConnection();

    public void consultElement() {
        try {

            Statement estado = connection.createStatement();

            String idElemento = null;
            String nomeElemento = null;
            ResultSet rs = estado.executeQuery( "select \"IdElemento\", \"NomeElemento\" from \"Elemento\"" );

            while (rs.next() ) {

                idElemento = rs.getString("IdElemento");
                nomeElemento = rs.getString("NomeElemento");

                System.out.printf(nomeElemento + ": " + idElemento);

                System.out.println();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
