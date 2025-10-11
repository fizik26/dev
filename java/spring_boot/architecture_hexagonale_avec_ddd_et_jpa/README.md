# Organisation d'un projet en architecture hexagonale

Ce projet est consituté d'un README montrant l'arborescence des fichiers pour un projet Java - Spring Boot proposant une architecture hexagonale et utilisant le principe de Domain-Driven Design (DDD) tout en utilisant JPA.

Des exemples de où se positionnent certaines classes et interface sont mentionnés

## Architecture :
```
├───main
│   ├───java
│   │   └───myapp
│   │       └───spring
│   │           ├───domain
│   │           │   ├───api
│   │           │   │   └─── interface_1.java
│   │           │   ├───ddd
│   │           │   ├───model
│   │           │   │   ├───model_1
│   │           │   │   │   └─── implementation_interface_1.java
│   │           │   │   ├───model_2
│   │           │   │   │   ├───sub_model_1
│   │           │   │   │   └───sub_model_2
│   │           │   └───spi
│   │           │       └─── interface_2.java
│   │           │       └─── interface_3.java
│   │           │       └───stub
│   │           │           └─── implementation_interface_2.java
│   │           └───infrastructure
│   │               ├───configuration
│   │               ├───controller
│   │               │   └───rest
│   │               │       ├───configuration
│   │               │       ├───filter
│   │               │       └───mapper
│   │               │       └─── delegate_1.java
│   │               └───provider
│   │                   └───jpa
│   │                   │   └─── implementation_interface_3_utilisation_interface_4.java
│   │                   │   └─── interface_4_extends_jparepository.java
│   │                   ├───mapper
│   │                   └───model
│   └───resources
└───test
    ├───java
    │   └───myapp
    │       └───spring
    │           ├───architecture
    │           ├───domain
    │           │   └───model
    │           ├───infrastructure
    │           │   └───configuration
    │           └───integration
    │               └───configuration
    └───resources
        ├───config

```