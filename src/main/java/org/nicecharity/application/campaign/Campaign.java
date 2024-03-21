package org.nicecharity.application.campaign;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "campaigns")
public class Campaign {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campaignId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal targetAmount;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "creator_id")
    // private User creator;  

    @Column(length=255)
    private String imageUrl;

    @Column(nullable = false)
    private BigDecimal currentAmount;
 

 


    // public boolean isActive() {
    //     return status == CampaignStatus.ACTIVE && startDate.before(new Date(System.currentTimeMillis())) && endDate.after(new Date(System.currentTimeMillis()));
    // }


   
    
}

// enum CampaignStatus {
//     DRAFT,
//     ACTIVE,
//     COMPLETED,
//     CANCELLED
// }

