package org.nicecharity.application.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins="https://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;
    
  
    @Autowired
    AuthenticationManager authenticationManager;
    @GetMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
    
          String username = loginRequest.getUsername();
          String password = loginRequest.getPassword();
          if(username == null || username.isEmpty() || password == null || password.isEmpty())
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new LoginResponse(false));
        UsernamePasswordAuthenticationToken token = 
        new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(token);
        return ResponseEntity.ok(new LoginResponse(true));
    }
  }

