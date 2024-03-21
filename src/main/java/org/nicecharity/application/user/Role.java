package org.nicecharity.application.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER("ROLE_USER"),
    CAMPAIGN_CREATOR("ROLE_CAMPAIGN_CREATOR");

    private final String authority;

    Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
