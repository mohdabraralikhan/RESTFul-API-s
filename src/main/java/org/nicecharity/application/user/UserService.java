package org.nicecharity.application.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean authenticateWithEmail(String email, String password) {
       User user = userRepository.findByEmail(email);
         if(user.equals(null))return false;
         else if(user.getPassword() == password){
            return true;
         }
         return false;

    }
    public boolean authenticateWithUsername(String username, String password) {
        User user = userRepository.findByUsername(username);
          if(user.equals(null))return false;
          else if(user.getPassword() == password){
             return true;
          }
          return false;
     }


    

}
