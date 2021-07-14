#### Experimento - Armazenamento de modelos de processos utilizando a notação em BPMN em banco de dados relacional e NoSQL

O projeto tem o objetivo de analisar o problema de impedância dos dados entre os bancos de dados relacionais e banco de dados NoSQL. Para realizar o estudo sobre o problema, foi desenvolvido um algoritmo em Java para realizar a leitura dos dados da modelagem de processo em BPMN, os dados foram armazenados nos bancos de dados [PostgreSQL](https://www.postgresql.org/) (Objeto Relacional) e [Neo4j](https://neo4j.com/) (Orientado a Grafos).

#### Configuração do Maven - Driver de conexão

Para conectar no banco de dados será necessário adicionar as seguintes dependências no arquivo pom.

#### PostgreSQL

```xml
<dependency>
    <groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<version>42.2.5</version>
</dependency>
```

#### Neo4j

```xml
<dependency>
	<groupId>org.neo4j.driver</groupId>
	<artifactId>neo4j-java-driver</artifactId>
	<version>4.1.1</version>
</dependency>
```

#### Conexão com o PostgreSQL

```java
    //Nome do usuário no banco de dados
    private String name = "postgre";
    //Senha do banco de dados
    private String password = "1234";
    //URL de conexão
    private String url = "jdbc:postgresql://localhost:5432/projeto"; // O "projeto" é meu database

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    url, name, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
```
#### Conexão com o Neo4j

```java
    //Nome do usuário no banco de dados
    private String name = "neo4j";
    //Senha do banco de dados
    private String password = "123";
    //URL de conexão
    private String url = "bolt://localhost:7687";

    public Driver getConnection() {
        try {
           return GraphDatabase.driver(url, AuthTokens.basic(name, password));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
```
### Modelos de Processos em BPMN

##### 1 - Abertura de Chamado

![Abertura de Chamado](https://github.com/lucasalexsandrosoares/ProjetoTCC/blob/master/Processos/Imagens/Abertura%20de%20Chamado.png)

##### 2 - Recebimento de Mercadoria

![Recebimento de Mercadoria](https://github.com/lucasalexsandrosoares/ProjetoTCC/blob/master/Processos/Imagens/Recebimento%20de%20Mercadoria.png)

##### 3 - Reembolso de Despesas de Viagem

![Reembolso de Despesas de Viagem](https://github.com/lucasalexsandrosoares/ProjetoTCC/blob/master/Processos/Imagens/Reembolso%20de%20Despesas%20de%20Viagem.png)

##### 4 - Solicitação de Compra

![Solicitação de Compra](https://github.com/lucasalexsandrosoares/ProjetoTCC/blob/master/Processos/Imagens/Solicitacao%20de%20Compra.png)

##### 5 - Solicitação de Inscrição em Evento

![Solicitação de Inscrição em Evento](https://github.com/lucasalexsandrosoares/ProjetoTCC/blob/master/Processos/Imagens/Solicitacao%20de%20Inscricao%20em%20Evento.png)

##### 6 - Solicitação de Peça de Reposição

![Solicitação de Peça de Reposição](https://github.com/lucasalexsandrosoares/ProjetoTCC/blob/master/Processos/Imagens/Solicitacao%20de%20Peca%20de%20Reposicao.png)

##### 7 - Solicitação de Viagem

![Solicitação de Viagem](https://github.com/lucasalexsandrosoares/ProjetoTCC/blob/master/Processos/Imagens/Solicitacao%20de%20Viagem.png)

##### 8 - Vendas de Produtos Bancários

![Vendas de Produtos Bancários](https://github.com/lucasalexsandrosoares/ProjetoTCC/blob/master/Processos/Imagens/Vendas%20de%20Produtos%20Bancarios.png)

#### Criado por:
 - Lucas Alexsandro Soares
