package org.nicecharity.application.donation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.nicecharity.application.campaign.Campaign;
import org.nicecharity.application.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donationId;

     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id",nullable = false)
    private Campaign campaign;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

  



    @Column(name = "donation_date")
    private LocalDateTime donationDate;

    @Column(name = "donation_amount")
    private BigDecimal donationAmount;

    @Column(nullable = false)
    private boolean isAnonymous = false;
  


    

}
