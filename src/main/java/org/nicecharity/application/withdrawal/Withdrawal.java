package org.nicecharity.application.withdrawal;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "withdrawals")
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long withdrawalId;

    @Column(name = "campaign_id")
    private Long campaignId;

    @Column(name = "request_date")
    private LocalDateTime requestDate;

    @Column(name = "request_amount")
    private BigDecimal requestAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private WithdrawalStatus status;

    // Getters and setters (omitted for brevity)

    public Withdrawal(Long campaignId, LocalDateTime requestDate, BigDecimal requestAmount, WithdrawalStatus status) {
        this.campaignId = campaignId;
        this.requestDate = requestDate;
        this.requestAmount = requestAmount;
        this.status = status;
    }

    public Withdrawal() {
    }
}

enum WithdrawalStatus {
    PENDING, APPROVED, REJECTED
}
