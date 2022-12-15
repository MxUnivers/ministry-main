package com.ministry.fullness.bodyChrist.controller;

import com.ministry.fullness.bodyChrist.entity.Members;
import com.ministry.fullness.bodyChrist.entity.User;
import com.ministry.fullness.bodyChrist.repository.MemberRepository;
import com.ministry.fullness.bodyChrist.security.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
     @Autowired
     public MemberRepository memberRepository;

    @PostMapping("/")
    public Members saveMember(@RequestBody Members newMember){
        return memberRepository.save(newMember);
    }

     // modificatio des informtions des utilisateurs
     @PutMapping("/{id}")
     Members updateMember(@RequestBody Members newMember, @PathVariable Long id) {
         Optional<Members> userOptimal =  memberRepository.findById(id);
         if(userOptimal.isPresent()){
             Members memberAccount = userOptimal.get();
             memberAccount.setName(newMember.getName());
             memberAccount.setCoverPicture(newMember.getCoverPicture());
             memberAccount.setEmail(newMember.getEmail());
             memberAccount.setCode(newMember.getCode());
             memberAccount.setTelephone(newMember.getTelephone());
             memberAccount.setPosition(newMember.getPosition());
             memberAccount.setPays(newMember.getPays());
             return  memberRepository.save(memberAccount);
         }else {
             throw new RuntimeException("Utilisateur non trouvé");
         }
     }

     // Stop Account
    @PutMapping("/setpassword/{id}")
    Members setpasswordMember(@PathVariable Long id, Members newUser) {
        Optional<Members> memberOptimal =  memberRepository.findById(id);
        if(memberOptimal.isPresent()){
            Members memberAccount = memberOptimal.get();
            memberAccount.setPassword(newUser.getPassword());
            return  memberRepository.save(memberAccount);
        }else {
            throw new RuntimeException("Membre no trouvé");
        }
    }

    // Ge all user
    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAllMember(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse(true, null, memberRepository.findAll()));
    }


}
