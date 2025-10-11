### Exemple tests d'architectures avec ArchUnit

Ici on teste pour vérifier que notre application respecte bien l'architecture hexagonale

`HexagonalArchitectureTest` teste que les classes ne soient pas mélangées entre l'infra et le domain
`InfrastructureArchitectureTest` teste qe les classes soient bien au bon endroit suivant leurs noms et annotations

| Dépendance     | Version   | URL                                                                                                       |
|:---------------|:----------|:----------------------------------------------------------------------------------------------------------|
| `archunit`     | `1.8.40` | [com.tngtech.archunit <archunit>](https://mvnrepository.com/artifact/com.tngtech.archunit/archunit/1.4.1) |

