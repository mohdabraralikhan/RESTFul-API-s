package org.nicecharity.application.user;

public enum Role {
    USER("user"),
    CAMPAIGN_CREATOR("campaign_creator");
    private final String role;
    Role(String role){
        this.role = role;
    }
    public String getRole(){
        return role;
    }
}
