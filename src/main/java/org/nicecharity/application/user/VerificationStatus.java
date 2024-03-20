package org.nicecharity.application.user;

public enum VerificationStatus {
    UNVERIFIED("unverified"),
    PENDING("pending"),
    VERIFIED("verified");
    private final String status;

VerificationStatus(String status){
    this.status = status;
}
public String getStatus(){
    return status;
}
}
