package ua.lvivl.libary.entity;

import org.springframework.security.core.GrantedAuthority;


public enum Role implements GrantedAuthority {
    USER("USER"),
    ADMINISTRATOR("ADMINISTRATOR");
    String name;


    Role(final String name){
        this.name=name;
    }
    @Override
    public String getAuthority() {
        return "ROLE_" + name;
    }
}
