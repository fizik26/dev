package com.example;

public enum Roles {
    ROLE_1("role_1"),
    ROLE_2("role_2"),
    ROLE_3("role_3"),
    ROLE_4("role_4"),
    ROLE_5("role_5"),
    ROLE_6("role_6");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
