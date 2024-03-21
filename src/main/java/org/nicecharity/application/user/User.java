package org.nicecharity.application.user;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails  {

   

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;
    
    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;
    
    @Column(name = "lock_status")
    private String lockStatus;
    
    @Column(name="locked") 
    private boolean isLocked;
    

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus;
    
    public enum VerificationStatus{
    UNVERIFIED,
    VERIFIED,
    PENDING
}
public void setLockStatus(AccountLockStatus lockedStatus) {
    this.lockStatus =lockedStatus.name(); 
    if(lockedStatus.name() == "UNLOCKED"){isLocked = false;}
    else{isLocked=true;}
  }
  public AccountLockStatus getLockStatus() {
    return AccountLockStatus.valueOf(this.lockStatus); 
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
      if (role != null) {
          return Collections.singletonList(role);
      }
      return Collections.emptyList();
  }
@Override
public boolean isAccountNonExpired() {
    return true;
}

@Override
public boolean isAccountNonLocked() {
    return !isLocked;
}


@Override
public boolean isCredentialsNonExpired() {
   return true;}

@Override
public boolean isEnabled() {
    if(verificationStatus.name() == "VERIFIED")return true;
    else{return false;}
}
   
public enum AccountLockStatus {
      
    TEMPORARY_LOCK,
    PERMANENT_LOCK,
    UNLOCKED
}
  
  }



