package org.nicecharity.application.user;

public  class LoginResponse {
    private boolean success;
    // private String sessionId;

    public LoginResponse(boolean success) {
        this.success = success;
        // this.sessionId = sessionId;
    }
}
