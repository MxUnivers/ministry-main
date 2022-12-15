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
    public User saveUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    //Mettre à jour l'utlisateur
     @PutMapping("/{id}")
     User updateUser(@RequestBody User newUser, @PathVariable Long id) {
         Optional<User> userOptimal =  userRepository.findById(id);
         if(userOptimal.isPresent()){
             User userAccount = userOptimal.get();
             userAccount.setActive(newUser.getActive());
             userAccount.setUsername(newUser.getUsername());
             userAccount.setEmail(newUser.getEmail());
             userAccount.setTelephone(newUser.getTelephone());
             userAccount.setFirstname(newUser.getFirstname());
             userAccount.setLastname(newUser.getLastname());
             userAccount.setRoles(newUser.getRoles());
             userAccount.setToken(newUser.getToken());
             return  userRepository.save(userAccount);
         }else {
             throw new RuntimeException("Utilisateur non trouvé");
         }
     }

    //Modifier Mot de passe
    @PutMapping("/setpassword/{id}")
     User UpdatePassword (@PathVariable("id") Long id,@RequestBody User newUser) {
         Optional<User> userOptimal =  userRepository.findById(id);
         if(userOptimal.isPresent()){
             User userAccount = userOptimal.get();
             userAccount.setPassword(newUser.getPassword());
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

    //DeleUser


}
