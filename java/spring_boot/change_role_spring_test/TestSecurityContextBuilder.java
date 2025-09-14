package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class TestSecurityContextBuilder {

    private TestSecurityContextBuilder() {

    }

    public static SecurityContext withRoleAndUserName(Roles role, String userName) {
        return getContextForUserRights(role, userName);
    }

    private static SecurityContext getContextForUserRights(Roles role, String userName) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        DemoUser demoUser = getDemoUser(role, userName);

        Authentication auth = new UsernamePasswordAuthenticationToken(demoUser, "password",
                new ArrayList<>(demoUser.getAuthorities()));
        context.setAuthentication(auth);
        return context;
    }

    private static DemoUser getDemoUser(Roles role, String userName) {
        List<String> authorities = new ArrayList<>();
        authorities.add(role.getRole());

        return new DemoUser(userName, authorities);
    }
}
