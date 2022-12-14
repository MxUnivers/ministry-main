package com.ministry.fullness.bodyChrist.controller;

import com.ministry.fullness.bodyChrist.entity.User;
import com.ministry.fullness.bodyChrist.repository.UserRepository;
import com.ministry.fullness.bodyChrist.security.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
     @Autowired
     public UserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity<ApiResponse> saveUser(){
        User user = userRepository.save(new User());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse(true, null, user)
        );
    }
     //Mettre a jour le compte
     @PutMapping("/{id}")
     User updateUser(@RequestBody User newUser, @PathVariable Long id) {
         Optional<User> userOptimal =  userRepository.findById(id);
         if(userOptimal.isPresent()){
             User userAccount = userOptimal.get();
             userAccount.setActive(newUser.getActive());
             userAccount.setUsername(newUser.getUsername());
             userAccount.setEmail(newUser.getEmail());
             userAccount.setFirstname(newUser.getFirstname());
             userAccount.setLastname(newUser.getLastname());
             userAccount.setRoles(newUser.getRoles());
             userAccount.setPassword(newUser.getPassword());
             userAccount.setToken(newUser.getToken());
             return  userRepository.save(userAccount);
         }else {
             throw new RuntimeException("Utilisateur non trouvé");
         }
     }

     // Stop Account
    @PatchMapping("/{id}")
    User desactiverUser(@PathVariable Long id, User newUser) {
        Optional<User> userOptimal =  userRepository.findById(id);
        if(userOptimal.isPresent()){
            User userAccount = userOptimal.get();
            userAccount.setAccess(newUser.getAccess());
            return  userRepository.save(userAccount);
        }else {
            throw new RuntimeException("Utilisateur non trouvé");
        }
    }

    // Ge all user
    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse(true, null, userRepository.findAll()));
    }


}
