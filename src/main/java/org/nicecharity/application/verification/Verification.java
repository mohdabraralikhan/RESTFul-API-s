package org.nicecharity.application.verification;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "verifications")
public class Verification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long verificationId;

    @Column(name = "user_id") // Assuming you have a user table
    private Long userId;

    @Column(name = "verification_type") // Could be email, phone, etc.
    private String verificationType;

    @Column(name = "verification_code")
    private String verificationCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private VerificationStatus status;

    // Getters and setters (omitted for brevity)

    public Verification(Long userId, String verificationType, String verificationCode, VerificationStatus status) {
        this.userId = userId;
        this.verificationType = verificationType;
        this.verificationCode = verificationCode;
        this.status = status;
    }

    public Verification() {
    }
}

 enum VerificationStatus {
    PENDING, VERIFIED, EXPIRED
}

