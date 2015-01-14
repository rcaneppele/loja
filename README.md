# Loja
Projeto com VRaptor4 + CDI + EJB + JPA + Wildfly8 + Bootstrap

## Requisitos
* Java 7;
* Maven 3;
* MySQL 5;
* Eclipse Luna ou Kepler;
* Wildfly 8.1.0.Final;

## Rodando o projeto
* Clone o repositório e importe o projeto no eclipse;
* Acesse o diretório do **Wildfly** e crie um **modulo** para o driver do MySQL(tutorial: http://www.thejavageek.com/2015/01/08/database-module-wildfly/);
* Adicione o seguinte **datasource** no arquivo **standalone.xml** do **Wildfly**:
``` xml
<datasource jndi-name="java:/lojaDS" pool-name="lojaDS" enabled="true" use-java-context="true">
	<connection-url>jdbc:mysql://localhost:3306/loja</connection-url>
	<driver>com.mysql</driver>
	<pool>
		<min-pool-size>10</min-pool-size>
		<max-pool-size>30</max-pool-size>
		<prefill>true</prefill>
	</pool>
	<security>
		<user-name>seu_usuario_do_mysql</user-name>
		<user-name>sua_senha_do_mysql</user-name>
	</security>
</datasource>
```
* Acesse o MySQL e crie um novo **database** chamado **loja**;
* No Eclipse, associe o projeto loja ao Wildfly e inicie o servidor;
* As tabelas serão criadas automaticamente(persistence.xml -> hbm2ddl.auto);
* Acesse o database loja no MySQL e insira um usuario(login: teste, senha: teste):
```sql
insert into Usuario(login,senha) values('teste', '9a3061b90f993945d63c52425ded0e6f00715de117c603dba9b705756f32dc172dc6ff7f97c8caec6109b0e685be7fb2475902dd71b33552636a5419dc259ccb');
```
* Acesse a aplicação em: **http://localhost:8080/loja**
