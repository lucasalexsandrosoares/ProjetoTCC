package tcc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReturnValuePGSQL {

    Connection connection = new ConnectionPGSQL().getConnection();

    public void selectElement(Integer id) {
        try {

            Statement estado = connection.createStatement();
            String idElemento = null;
            String nomeElemento = null;
            ResultSet rs = estado.executeQuery( "select \"IdElemento\", \"NomeElemento\" from \"Elemento\" where \"IdProcesso\" = '"+id+"'" );

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

    public void selectFlow(Integer id) {
        try {

            Statement estado = connection.createStatement();
            String elementoOrigem = null;
            String elementoDestino = null;
            ResultSet rs = estado.executeQuery( "select \n" +
                    "concat(T1.\"NomeElemento\",': ',T0.\"ElementoOrigem\") as \"ElementoOrigem\", \n" +
                    "concat(T2.\"NomeElemento\",': ', T0.\"ElementoDestino\") as \"ElementoDestino\"  \n" +
                    "from \"Fluxo\" T0\n" +
                    "inner join \"Elemento\" T1 on T0.\"ElementoOrigem\"  = T1.\"IdElemento\"\n" +
                    "inner join \"Elemento\" T2 on T0.\"ElementoDestino\" = T2.\"IdElemento\"\n" +
                    "inner join \"Processo\" T3 on T1.\"IdProcesso\" = T3.\"IdProcesso\"" +
                    "where T3.\"IdProcesso\" = '"+id+"'");

            while (rs.next() ) {

                elementoOrigem = rs.getString("ElementoOrigem");
                elementoDestino = rs.getString("ElementoDestino");

                System.out.printf(elementoOrigem + " -> " + elementoDestino);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
