package org.nicecharity.application.verification;


import java.time.LocalDateTime;

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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "verifications")
public class Verification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long verificationId;

 @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;



  @Enumerated(EnumType.STRING)
  private VerificationMethod method;
   
  @Column(nullable = false)
  private LocalDateTime verificationDate;

  @Lob
  private byte[] verificationData;
  
    public enum VerificationMethod{
        EMAIL,
        ID_SCAN,
        SOCIAL_MEDIA
    }
}



