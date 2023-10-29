package com.example;

import java.util.Collection;
import java.util.Objects;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class DemoUser implements UserDetails {

    private final String username;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Collection<GrantedAuthority> authorities;

    protected DemoUser() {
        this.username = "tt";
        this.firstName = "tt";
        this.lastName = "tt";
        this.email = "tt";
        this.authorities = null;
    }

    public DemoUser(String userName, String firstName, String lastName, String email, List<String> authorities) {
        this.username = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        if (Objects.nonNull(authorities)) {
            this.authorities = AuthorityUtils.createAuthorityList((String[]) authorities.toArray(new String[0]));
        } else {
            this.authorities = null;
        }
    }

    public DemoUser(String userName, List<String> authorities) {
        this.username = userName;
        this.firstName = "tt";
        this.lastName = "tt";
        this.email = "tt";

        if (Objects.nonNull(authorities)) {
            this.authorities = AuthorityUtils.createAuthorityList((String[]) authorities.toArray(new String[0]));
        } else {
            this.authorities = null;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        throw new IllegalStateException();
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getlastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }
}
