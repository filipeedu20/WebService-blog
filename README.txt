README

Comments:
=========

----------------------------------------------------------------
- AUTORES 
POST/PUT/DELETE/GET
http://localhost:8080/templatejee/rest/autor/

* Estrutura do json para inserir autor
 
{
  "id": null,
   "nome": "Maria Aparecida"
}
----------------------------------------------------------------

- POSTAGENS 
POST/PUT/DELETE/GET
http://localhost:8080/templatejee/rest/postagem/

* Estrutura para inserir postagem
{
  "id": null,
  "postagem": "Conteudo da postagem 4",
  "data": null
}

----------------------------------------------------------------
- COMENTÁRIOS 
POST/PUT/DELETE/GET

http://localhost:8080/templatejee/rest/comentario/

* Estrutura para inserir comentários
{
  "id": null,
  "nome_pessoa": "Claudio",
  "comentario": "Comentario para testar",  
  "data":null
}


Commands:
=========

To run tests:  mvn test

To start application:  mvn -Dmaven.test.skip=true wildfly:run


Application Tests:	
==================

