package by.belstu.bless.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    User, Admin, Doctor;

    @Override
    public String getAuthority() {
        return name();
    }
}
