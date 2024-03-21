package org.nicecharity.application.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
MyUserDetailsService(UserRepository userRepository,PasswordEncoder passwordEncoder){
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
}
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found with username" + username);
        }
        if (user != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword())); 
        }
        return user;
    }
}
