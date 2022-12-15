package com.ministry.fullness.bodyChrist.controller;

import com.ministry.fullness.bodyChrist.entity.Temoignage;
import com.ministry.fullness.bodyChrist.repository.TemoignageRepository;
import com.ministry.fullness.bodyChrist.security.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/v1/temoignages")
@RestController
public class TemoignageController {
    @Autowired
    TemoignageRepository temoignageRepository ;

    @PostMapping("/")
    public Temoignage saveTemoignage (@RequestBody Temoignage newTemoignage ){
        return temoignageRepository.save(newTemoignage);
    }

    @PutMapping("/{id}")
    Temoignage updateTemoignage  (@PathVariable("id") Long id , @RequestBody Temoignage newTemoignage){
        Optional<Temoignage> temoinOptional = temoignageRepository.findById(id);
        if (temoinOptional.isPresent()){
            Temoignage temoin =  temoinOptional.get();
            temoin.setContent(newTemoignage.getContent());
            temoin.setDescription(newTemoignage.getDescription());
            temoin.setCoverPicture(newTemoignage.getCoverPicture());
            temoin.setTitle(newTemoignage.getTitle());
            return  temoignageRepository.save(newTemoignage);
        }else {
            throw new RuntimeException("Temoignage non trouvé");
        }
    }
    @PutMapping("hide/{id}")
    Temoignage cacherTemoignage  (@PathVariable("id") Long id ){
        Optional<Temoignage> temoinOptional = temoignageRepository.findById(id);
        if (temoinOptional.isPresent()){
            Temoignage temoin =  temoinOptional.get();
            temoin.setVisible(false);
            return  temoignageRepository.save(temoin);
        }else {
            throw new RuntimeException("Temoignage non trouvé");
        }
    }
    @PutMapping("show/{id}")
    Temoignage montrerTemoignage  (@PathVariable("id") Long id ){
        Optional<Temoignage> temoinOptional = temoignageRepository.findById(id);
        if (temoinOptional.isPresent()){
            Temoignage temoin =  temoinOptional.get();
            temoin.setVisible(false);
            return  temoignageRepository.save(temoin);
        }else {
            throw new RuntimeException("Temoignage non trouvé");
        }
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAlltemoignage(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse(true, null, temoignageRepository.findAll()));
    }



}
