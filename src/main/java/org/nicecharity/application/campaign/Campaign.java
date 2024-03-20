package org.nicecharity.application.campaign;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.nicecharity.application.user.User;
import org.nicecharity.application.withdrawal.Withdrawal;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)  
    private Date startDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)  
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;  // Assuming a User entity exists

    @Enumerated(EnumType.STRING)
    private CampaignStatus status;  // Enum for campaign status (e.g., DRAFT, ACTIVE, COMPLETED)

    private BigDecimal targetBudget;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)  // OneToMany relationship with optional cascade
    private List<Withdrawal> withdrawalRequests;  // Assuming a WithdrawalRequest entity exists


    public boolean isActive() {
        return status == CampaignStatus.ACTIVE && startDate.before(new Date(System.currentTimeMillis())) && endDate.after(new Date(System.currentTimeMillis()));
    }


    public void addDonation(BigDecimal amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addDonation'");
    }
    
}

enum CampaignStatus {
    DRAFT,
    ACTIVE,
    COMPLETED,
    CANCELLED
}

