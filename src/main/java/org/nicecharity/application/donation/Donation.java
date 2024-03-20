package org.nicecharity.application.donation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donationId;

    @Column(name = "donor_id") // Assuming you have a donor table
    private Long donorId;

    @Column(name = "campaign_id")
    private Long campaignId;

    @Column(name = "donation_date")
    private LocalDateTime donationDate;

    @Column(name = "donation_amount")
    private BigDecimal donationAmount;

    // Getters and setters (omitted for brevity)

    public Donation(Long donorId, Long campaignId, LocalDateTime donationDate, BigDecimal donationAmount) {
        this.donorId = donorId;
        this.campaignId = campaignId;
        this.donationDate = donationDate;
        this.donationAmount = donationAmount;
    }

    public Donation() {
    }
}
