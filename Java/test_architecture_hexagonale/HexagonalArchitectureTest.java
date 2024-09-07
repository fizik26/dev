package Java.test_architecture_hexagonale;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

/**
 * packages = le package de l'appli qui contient tous les dossiers (controllers,
 * domain ...)
 */
@AnalyzeClasses(packages = "com.myapp.springapp")
class HexagonalArchitectureTest {

    private static final String DOMAIN_PACKAGE_IDENTIFIER = "com.myapp.springapp..domain..";

    private static final String API_PACKAGE_IDENTIFIER = "com.myapp.springapp..domain.api..";

    private static final String SERVICE_PACKAGE_IDENTIFIER = "com.myapp.springapp..domain.service..";

    private static final String SPI_PACKAGE_IDENTIFIER = "com.myapp.springapp..domain.spi..";

    private static final String CONTROLLER_PACKAGE_IDENTIFIER = "com.myapp.springapp..controller..";

    private static final String PROVIDER_PACKAGE_IDENTIFIER = "com.myapp.springapp..provider..";

    @ArchTest
    static final ArchRule domain_should_not_depend_on_controller_or_provider = noClasses().that()
            .resideInAPackage(DOMAIN_PACKAGE_IDENTIFIER)
            .should().dependOnClassesThat()
            .resideInAnyPackage(CONTROLLER_PACKAGE_IDENTIFIER, PROVIDER_PACKAGE_IDENTIFIER);

    @ArchTest
    static final ArchRule controller_should_not_depend_on_provider = noClasses().that()
            .resideInAPackage(CONTROLLER_PACKAGE_IDENTIFIER)
            .should().dependOnClassesThat().resideInAnyPackage(PROVIDER_PACKAGE_IDENTIFIER);

    @ArchTest
    static final ArchRule controller_should_not_depend_on_spi = noClasses().that()
            .resideInAPackage(CONTROLLER_PACKAGE_IDENTIFIER)
            .should().dependOnClassesThat().resideInAnyPackage(SPI_PACKAGE_IDENTIFIER);

    @ArchTest
    static final ArchRule provider_should_not_depend_on_controller = noClasses().that()
            .resideInAPackage(PROVIDER_PACKAGE_IDENTIFIER)
            .should().dependOnClassesThat().resideInAnyPackage(CONTROLLER_PACKAGE_IDENTIFIER);

    @ArchTest
    static final ArchRule provider_should_not_depend_on_api_or_service = noClasses().that()
            .resideInAPackage(PROVIDER_PACKAGE_IDENTIFIER)
            .should().dependOnClassesThat().resideInAnyPackage(API_PACKAGE_IDENTIFIER, SERVICE_PACKAGE_IDENTIFIER);

}