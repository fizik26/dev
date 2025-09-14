Code permettant de mettre en mémoire les valeurs contenues dans un fichier JSON
Il faut imaginer un Projet Spring Boot avec le fichier voitures.json dans le dossier main/resources/json/

Ajout du repository permettant d'interroger les valeurs présentes dans le JSON





# JSON to Bean

Code permettant de mettre en mémoire les valeurs contenues dans un fichier JSON.
Ici, notre fichier Json `voiures.json` (déclaré dans le `application.yml`) va être lu lors de l'initialisation de l'environnement Spring.
Les valeurs seront accessibles via le repository `MomoryVoitureRepository`.


### Dépendances nécessaires (avec Maven)



| Dépendance     | Version   | URL                                                                                                           |
|:---------------|:----------|:--------------------------------------------------------------------------------------------------------------|
| `lombok`       | `1.18.40` | [org.projectlombok <lombok>](https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.40)             |
| `swagger-core` | `2.2.36`  | [io.swagger.core.v3 <swagger-core>](https://mvnrepository.com/artifact/io.swagger.core.v3/swagger-core/2.2.36) |

