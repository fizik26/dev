package java.spring_boot.test_architecture_hexagonale;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.myapp.springapp")
public class InfrastructureArchitectureTest {

    @ArchTest
    public static final ArchRule controllersShouldBeAnnotedAsIsRule = classes()
            .that().resideInAPackage("com.myapp.springapp.infrastructure.controller..")
            .and().haveNameMatching("(.*Controller)|(.*Delegate)")
            .and().areNotInterfaces()
            .should().beAnnotatedWith(Controller.class)
            .orShould().beAnnotatedWith(RestController.class);

    @ArchTest
    public static final ArchRule providersShouldBeAnnotedAsIsRule = classes()
            .that().resideInAPackage("com.myapp.springapp.infrastructure.provider..")
            .and().haveSimpleNameEndingWith("Repository")
            .and().areNotInterfaces()
            .should().beAnnotatedWith(Repository.class);

}
