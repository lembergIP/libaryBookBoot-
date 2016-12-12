package ua.lvivl.libary.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by lembergIP on 17.10.2016.
 */
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
