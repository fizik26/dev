import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.test.context.support.WithSecurityContext;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockUserSecurityContextFactory.class)
public @interface WithMockUser {
    String firstName() default "John";

    String lastName() default "Doe";

    String userName() default "12454154";

    String email() default "user@email.fr";

    String phone() default "+3311111111";

    Roles[] authorities() default { Roles.ROLE_2 };
}
