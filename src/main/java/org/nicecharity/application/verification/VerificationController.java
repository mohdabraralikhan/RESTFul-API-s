package org.nicecharity.application.verification;

import org.nicecharity.application.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/verification")
public class VerificationController {

    @Autowired
    private UserService userService;

    @PostMapping("/{userId}/verify")
    public ResponseEntity<String> verifyUser(@PathVariable Long userId, @RequestBody VerificationRequest request) {
        userService.verifyUser(userId, request); // Implement verification logic
        return ResponseEntity.ok("Verification successful");
    }

    // Add methods for resend verification email, etc.
    // ...
}

