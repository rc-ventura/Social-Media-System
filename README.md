## 💻 Backend Spring Data Social Media Project 

 ### API REST FULL - CRUD



​														UML Representation



![](C:\Users\RC_Ve\OneDrive\Documentos\NetBeansProjects\BackEndSpring_Aula\BackEnd_SpringBoot_Postagem\UML representation.png)




#### Technologies:

JAVA

SPRING BOOT

JPA

HIBERNATE




### endpoints:



GET: /entities

* </postagens>	       http://localhost:8080/postagens

* </assuntos>             http://localhost:8080/assuntos

* </comentarios>      http://localhost:8080/comentarios

* </editores>             http://localhost:8080/editores



GET: /entities/{id}

*  <postagens>/<id>                  http://localhost:8080/postagens/1

*  <assuntos>/<id>                    http://localhost:8080/assuntos/1

* <comentarios>/<id>              http://localhost:8080/comentarios/1

* <editores>/<id>                     http://localhost:8080/editores/1



POST: /entities

* </postagens>	       http://localhost:8080/postagens

* </assuntos>             http://localhost:8080/assuntos

* </comentarios>      http://localhost:8080/comentarios

* </editores>             http://localhost:8080/editores



PUT: /entities/{id}

*  <postagens>/<id>                  http://localhost:8080/postagens/1

*  <assuntos>/<id>                    http://localhost:8080/assuntos/1

* <comentarios>/<id>              http://localhost:8080/comentarios/1

* <editores>/<id>                     http://localhost:8080/editores/1



DELETE : /entities/{id}

*  <postagens>/<id>                  http://localhost:8080/postagens/1

*  <assuntos>/<id>                    http://localhost:8080/assuntos/1

* <comentarios>/<id>              http://localhost:8080/comentarios/1

* <editores>/<id>                     http://localhost:8080/editores/1



* RELATIONSHIP

​	

PUT: /entity1/{id}/addEntity2/{id}



<Postagem> + <Comentario>   http://localhost:8080/postagens/1/addComentario/4

<Postagem> + <Assunto>          http://localhost:8080/postagens/1/addAssunto/4

<Editor> + <Postagem>            http://localhost:8080/editores/1/addPostagem/4



DELETE: /entity1/{id}/removeEntity2/{id}



<Postagem> - <Comentario>   http://localhost:8080/postagens/1/removeComentario/4

<Postagem> - <Assunto>          http://localhost:8080/postagens/1/removeAssunto/4

<Editor> - <Postagem>            http://localhost:8080/editores/1/removePostagem/4



