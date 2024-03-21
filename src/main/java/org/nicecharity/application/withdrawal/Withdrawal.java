package org.nicecharity.application.withdrawal;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.nicecharity.application.campaign.Campaign;
import org.nicecharity.application.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "withdrawals")
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long withdrawalId;

 @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id",nullable = false)
    private Campaign campaign;

    

    @Column(name = "request_date")
    private LocalDateTime requestDate;

    @Column(name = "request_amount")
    private BigDecimal requestAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private WithdrawalStatus status;



   
}

enum WithdrawalStatus {
    PENDING, APPROVED, REJECTED
}
