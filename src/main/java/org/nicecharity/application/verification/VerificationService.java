package org.nicecharity.application.verification;

import org.nicecharity.application.user.User;
import org.nicecharity.application.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationService {

    @Autowired
    private UserService userService;  // Assuming a UserService exists

    public void verifyUser(Long userId, String verificationCode) {
        User user = userService.getUserById(userId);
        if (user != null && user.getVerificationStatus().equals(verificationCode)) {
            user.setVerificationStatus(VerificationStatus.VERIFIED);
            userService.createUser(user);  // Update user with verified status
        } else {
            // Handle invalid verification code scenario
        }
    }

    // Additional methods for verification logic (e.g., sending verification emails)
}

