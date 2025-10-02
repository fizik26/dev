# Helper with MapStruct

Exemple d'un helper dans MapStruct.

L'helper `UserMapperHelper` va permettre d'utiliser un service `UserAppService`

L'helper va ainsi définir une méthode `getTypeUser` qui pourra être utilisé par tous les Mapper utilisant cet helper.

Ainsi, avec l'annotation `@Mapper(uses = UserMapperHelper.class)` , les mappers `ReportingMapper` et `TableMapper` utilisent la méthode définie dans l'helper qui lui même appelle un service sans devoir définir cela dans chacune des interfaces MapStruct.

### Dépendances nécessaires (avec Maven)



| Dépendance                 | Version   | URL                                                                                                                            |
|:---------------------------|:----------|:-------------------------------------------------------------------------------------------------------------------------------|
| `lombok`                   | `1.18.40` | [org.projectlombok <lombok>](https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.40)                              |
| `mapstruct`                | `1.6.3`   | [org.mapstruct <mapstruct>](https://mvnrepository.com/artifact/org.mapstruct/mapstruct/1.6.3)                                  |
| `mapstruct-processor`      | `1.6.3`   | [org.mapstruct <mapstruct-processor>](https://mvnrepository.com/artifact/org.mapstruct/mapstruct-processor/1.6.3)              |
| `lombok-mapstruct-binding` | `0.2.0`   | [org.projectlombok <lombok-mapstruct-binding>](https://mvnrepository.com/artifact/org.projectlombok/lombok-mapstruct-binding/0.2.0) |

