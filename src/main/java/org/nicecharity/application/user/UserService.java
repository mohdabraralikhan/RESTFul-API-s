package org.nicecharity.application.user;

import java.util.List;
import java.util.Optional;

import org.nicecharity.application.verification.VerificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        // Business logic for user creation (e.g., password hashing)
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long userId) {
       return userRepository.findById(userId);
    }

    public void verifyUser(Long userId, VerificationRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyUser'");
    }

    // Additional methods for verification, updating user info, etc.
}
