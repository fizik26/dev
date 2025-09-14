import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

public class WithMockUserSecurityContextFactory implements WithSecurityContextFactory<WithMockUser> {

    @Override
    public SecurityContext createSecurityContext(WithMockUser withMockUser) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        DemoUser demoUser = getDemoUser(withMockUser);
        Authentication auth = new UsernamePasswordAuthenticationToken(demoUser, "password", demoUser.getAuthorities());
        context.setAuthentication(auth);
        return context;
    }

    private DemoUser getDemoUser(WithMockUser withMockUser) {
        List<String> authorities = new ArrayList<>();
        for(Roles role : withMockUser.authorities()) {
            authorities.add(role.getRole());
        }

        return new DemoUser(withMockUser.userName(), withMockUser.firstName(), withMockUser.lastName(), withMockUser.email(), authorities);
    }
    
}
