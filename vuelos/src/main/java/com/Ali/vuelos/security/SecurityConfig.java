package com.Ali.vuelos.security;

import org.keycloak.adapters.springsecurity.authentication.KeycloakLogoutHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final String GROUPS = "groups";
    private static final String REALM_ACCES_CLAIM = "real_access";
    private static final String ROLES_CLAIM = "roles";

    private final KeycloakLogoutHandler keycloakLogoutHandler;

    public SecurityConfig(KeycloakLogoutHandler keycloakLogoutHandler){
        this.keycloakLogoutHandler = keycloakLogoutHandler;
    }



}
