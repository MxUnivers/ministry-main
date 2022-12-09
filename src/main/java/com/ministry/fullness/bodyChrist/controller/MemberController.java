package com.ministry.fullness.bodyChrist.controller;

import com.ministry.fullness.bodyChrist.entity.Members;
import com.ministry.fullness.bodyChrist.entity.User;
import com.ministry.fullness.bodyChrist.repository.MemberRepository;
import com.ministry.fullness.bodyChrist.security.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/member")
public class MemberController {
     @Autowired
     public MemberRepository memberRepository;

     @PostMapping("/")
     public Members saveUser (@RequestBody Members newMember ){
         return memberRepository.save(newMember);
     }
     //Mettre a jour le compte
     @PutMapping("/{id}")
     Members updateUser(@RequestBody Members newMember, @PathVariable Long id) {
         Optional<Members> userOptimal =  memberRepository.findById(id);
         if(userOptimal.isPresent()){
             Members memberAccount = userOptimal.get();
             memberAccount.setEmail(newMember.getEmail());
             memberAccount.setName(newMember.getEmail());
             memberAccount.setPays(newMember.getEmail());
             memberAccount.setAccess(newMember.getAccess());

             return  memberRepository.save(memberAccount);
         }else {
             throw new RuntimeException("Utilisateur non trouvé");
         }
     }

     // Stop Account
    @PatchMapping("/{id}")
    Members desactiverUser(@PathVariable Long id, Members newUser) {
        Optional<Members> memberOptimal =  memberRepository.findById(id);
        if(memberOptimal.isPresent()){
            Members memberAccount = memberOptimal.get();
            memberAccount.setAccess(newUser.getAccess());
            return  memberRepository.save(memberAccount);
        }else {
            throw new RuntimeException("Nembre no  ris en chagrge non trouvé");
        }
    }

    // Ge all user
    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse(true, null, memberRepository.findAll()));
    }


}
