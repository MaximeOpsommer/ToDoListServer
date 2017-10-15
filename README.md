Delassus Alexandre
Opsommer Maxime

## OPL - Online ToDo List

This project is a lightweight and easy-to-use skeleton to create a JEE application that uses [Apache TomEE](http://openejb.apache.org/apache-tomee.html), a complete JEE server based on Tomcat.

### Structure

  * `main/java/car/tp4/entity`
    
    Contains all entities (EJB) (`Liste` and `Item`).
    
  * `main/java/car/tp4/servlet`
  
    Contains all servlets (`ListeServlet` example).
    
  * `resources/META-INF`
    
    Contains all the configuration files for the deployment.
    `persistence.xml` declares how to persist the app beans.
    We have to write a `persistence-unit` for each bean of the application.
    
  * `webapp/jsp`
  
  Contains all the jsp files, excepts the index.
  
  * `webapp/WEB-INF`
  
  Contains all the configuration files for the web application.
  The mapping between each URL/Servlet has to be down in the `web.xml` file (see example).

### How to?

To build the application and to start the server:
```
mvn clean package tomee:run
```

Once started, the application is now reachable at:
```
http://localhost:8080
```

When developing, all the static resources (html, css, jsp) are automatically re-deployed on the server (in few seconds).

For the Java class, you can open a new terminal (without to stop the server), and package the application (`mvn package`) for a new automatic redeployment.

To clean all data and remove the application, use `mvn:clean`.


```

Listes des URL :

localhost:8080/listes (ensembles des listes)

localhost:8080/createListe (pour créer une nouvelle liste)

localhost:800/editListe?idListe=<idListe> (pour aller sur la gestion d'une liste : valider et ajouter des Items)


Il y a un lien pour aller de create à edit, les autres URL doivent être rentrées manuellement.



Difficultés rencontrées :
-------------------------


Setup de la base de données avec notre serveur web : Nous avons changé plusieurs fois de technos jusqu'à réussir à avoir quelque chose qui fonctionne. Nous avons finalement adopter un serveur tomcat avec des EJB et JSP (nous avons repris notre TP4 de CAR de l'année dernière et branché notre BDD dessus).


Faire fonctionner Concordion : Nous avons du comprendre l'architecture et la syntaxe spécifique à Concordion avant de réussir à faire marcher notre premier test.
Néanmoins une erreur est revenue (nous ne savons pas si cela provient des configurations d'Eclipse) mais lorsque nous tentons de lancer des Fixture Concordion, la classe est "introuvable" alors qu'elle est bien présente.


Problème inconnu : La servlet qui gère l'ajout d'item appele correctement la BDD pour ajouter un Item mais celui-ci n'est pas présent (alors que la méthode est la même que pour les Liste)


Nous avons du mal à visualiser comment tester (avec JUnit) les appels en Base de Données sans mocker l'intégralité des fonctions, ce qui a... peu d'intérêt.