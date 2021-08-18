

# API em java Condominio
Uma API REST para controle de fluxo de visitantes de um condominio

<h2>Tecnologias:</h2>

-As tecnologias usada no porjeto sao :</br>
-Sprintg-boot </br>
-Spring-mvc </br>
-Spring-data </br>
-JPA </br>
-h2 database </br>
-junit </br>
-Lombock </br>

Para executar o projeto, será necessário instalar os seguintes programas:

JDK 11: Necessário para executar o projeto Java
Maven 3.5.3: Necessário para realizar o build e as  importações das bibliotecas do projeto Java
Intellij: Para desenvolvimento do projeto

Construção
Para construir o projeto com o Maven, executar os comando abaixo:

```shell script
mvn clean install
```
O comando irá baixar todas as dependências do projeto e criar um diretório target com os
artefatos construídos, que incluem o arquivo jar do projeto. Além disso, serão executados
os testes unitários, e se algum falhar, o Maven exibirá essa informação no console.

<h2>Subir servidor local </h2>

```shell script
mvn spring-boot:run
```

O comando ira levantar um servidor H2 um banco de dados relacional escrito em Java
a aplicação ira rodar na url: 

```shell script
 http://localhost:8080/
```



<h2>Testes </h2>
Para rodar os testes, utilize o comando abaixo:
```shell script
mvn test
```
 
