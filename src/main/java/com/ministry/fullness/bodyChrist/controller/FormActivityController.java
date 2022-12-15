package com.ministry.fullness.bodyChrist.controller;

import com.ministry.fullness.bodyChrist.entity.FormActity;
import com.ministry.fullness.bodyChrist.repository.FormActivityRepository;
import com.ministry.fullness.bodyChrist.security.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.Optional;


@Controller
@RequestMapping("/api/v1/activites")
public class FormActivityController {
    @Autowired
    FormActivityRepository formActivityRepository;

    // ******************************************** les PROGRAMMES **************************
    @PostMapping("/programmes/")
    public FormActity createPrgramme (@RequestBody FormActity newActivity){
        return formActivityRepository.save(newActivity);
    }
    @PutMapping("/programmes/{id}")
    FormActity updateFormActvity(@PathVariable("id") Long id  ,  @RequestBody FormActity formActity){
        Optional<FormActity> optionalFormActity = formActivityRepository.findById(id);
        if(optionalFormActity.isPresent()){
            FormActity form =  optionalFormActity.get();
            form.setContent(form.getContent());
            form.setCoverPicture(form.getCoverPicture());
            form.setDescription(form.getCoverPicture());
            form.setTitle(form.getTitle());
            form.setTypeActivity("programme");
            form.setContent(form.getContent());
            form.setVideo(form.getVideo());
            form.setAudio(form.getAudio());
            return formActivityRepository.save(form);
        }else {
            throw new RuntimeException("non trouvé");
        }
    }

    @PutMapping("/programmes/hide/{id}")
    FormActity hideFormActvity(@PathVariable("id") Long id  ,  @RequestBody FormActity formActity){
        Optional<FormActity> optionalFormActity = formActivityRepository.findById(id);
        if(optionalFormActity.isPresent()){
            FormActity form =  optionalFormActity.get();
            form.setVisible(false);
            return formActivityRepository.save(form);
        }else {
            throw new RuntimeException("non trouvé");
        }
    }

    @PutMapping("/programmes/show/{id}")
    FormActity showFormActvity(@PathVariable("id") Long id  ,  @RequestBody FormActity formActity){
        Optional<FormActity> optionalFormActity = formActivityRepository.findById(id);
        if(optionalFormActity.isPresent()){
            FormActity form =  optionalFormActity.get();
            form.setVisible(true);
            return formActivityRepository.save(form);
        }else {
            throw new RuntimeException("non trouvé");
        }
    }


    // **********************************************  les ECOLE **************************

    // Ajout un enseignement
    @PostMapping("/school/")
    public FormActity createEnseignement (@RequestBody FormActity newActivity){
        return formActivityRepository.save(newActivity);
    }
    // Modifier un enseignement
    @PutMapping("/school/{id}")
    FormActity updateEnseignament(@PathVariable("id") Long id  ,  @RequestBody FormActity formActity){
        Optional<FormActity> optionalFormActity = formActivityRepository.findById(id);
        if(optionalFormActity.isPresent()){
            FormActity form =  optionalFormActity.get();
            form.setContent(form.getContent());
            form.setCoverPicture(form.getCoverPicture());
            form.setDescription(form.getCoverPicture());
            form.setTitle(form.getTitle());
            form.setTypeActivity("enseignement");
            form.setContent(form.getContent());
            form.setVideo(form.getVideo());
            form.setAudio(form.getAudio());
            return formActivityRepository.save(form);
        }else {
            throw new RuntimeException("non trouvé");
        }
    }
    // Boquer Enseignement
    @PutMapping("/school/hide/{id}")
    FormActity hideEnseignement(@PathVariable("id") Long id  ,  @RequestBody FormActity formActity){
        Optional<FormActity> optionalFormActity = formActivityRepository.findById(id);
        if(optionalFormActity.isPresent()){
            FormActity form =  optionalFormActity.get();
            form.setVisible(false);
            return formActivityRepository.save(form);
        }else {
            throw new RuntimeException("non trouvé");
        }
    }
    //Débloquer un témoignage
    @PutMapping("/school/show/{id}")
    FormActity showEnseignement(@PathVariable("id") Long id  ,  @RequestBody FormActity formActity){
        Optional<FormActity> optionalFormActity = formActivityRepository.findById(id);
        if(optionalFormActity.isPresent()){
            FormActity form =  optionalFormActity.get();
            form.setVisible(true);
            return formActivityRepository.save(form);
        }else {
            throw new RuntimeException("non trouvé");
        }
    }


    // **********************************************  les EVENT **************************

    // Ajout un enseignement
    @PostMapping("/event/")
    public FormActity createEvent (@RequestBody FormActity newActivity){
        return formActivityRepository.save(newActivity);
    }
    // Modifier un enseignement
    @PutMapping("/event/{id}")
    FormActity updateEvent(@PathVariable("id") Long id  ,  @RequestBody FormActity formActity){
        Optional<FormActity> optionalFormActity = formActivityRepository.findById(id);
        if(optionalFormActity.isPresent()){
            FormActity form =  optionalFormActity.get();
            form.setContent(form.getContent());
            form.setCoverPicture(form.getCoverPicture());
            form.setDescription(form.getCoverPicture());
            form.setTitle(form.getTitle());
            form.setTypeActivity("evenement");
            form.setContent(form.getContent());
            form.setVideo(form.getVideo());
            form.setAudio(form.getAudio());
            return formActivityRepository.save(form);
        }else {
            throw new RuntimeException("non trouvé");
        }
    }
    // Boquer Enseignement
    @PutMapping("/event/hide/{id}")
    FormActity hideEvent(@PathVariable("id") Long id  ,  @RequestBody FormActity formActity){
        Optional<FormActity> optionalFormActity = formActivityRepository.findById(id);
        if(optionalFormActity.isPresent()){
            FormActity form =  optionalFormActity.get();
            form.setVisible(false);
            return formActivityRepository.save(form);
        }else {
            throw new RuntimeException("non trouvé");
        }
    }
    //Débloquer un témoignage
    @PutMapping("/event/show/{id}")
    FormActity showEvent(@PathVariable("id") Long id  ,  @RequestBody FormActity formActity){
        Optional<FormActity> optionalFormActity = formActivityRepository.findById(id);
        if(optionalFormActity.isPresent()){
            FormActity form =  optionalFormActity.get();
            form.setVisible(true);
            return formActivityRepository.save(form);
        }else {
            throw new RuntimeException("non trouvé");
        }
    }





    // **********************************************   Les DONS **************************

    // Ajout un enseignement
    @PostMapping("/event/")
    public FormActity createDon (@RequestBody FormActity newActivity){
        return formActivityRepository.save(newActivity);
    }
    // Modifier un enseignement
    @PutMapping("/event/{id}")
    FormActity updateDon(@PathVariable("id") Long id  ,  @RequestBody FormActity formActity){
        Optional<FormActity> optionalFormActity = formActivityRepository.findById(id);
        if(optionalFormActity.isPresent()){
            FormActity form =  optionalFormActity.get();
            form.setContent(form.getContent());
            form.setCoverPicture(form.getCoverPicture());
            form.setDescription(form.getCoverPicture());
            form.setTitle(form.getTitle());
            form.setTypeActivity("dons");
            form.setContent(form.getContent());
            form.setVideo(form.getVideo());
            form.setAudio(form.getAudio());
            return formActivityRepository.save(form);
        }else {
            throw new RuntimeException("non trouvé");
        }
    }
    // Boquer Enseignement
    @PutMapping("/dons/hide/{id}")
    FormActity hideDon(@PathVariable("id") Long id  ,  @RequestBody FormActity formActity){
        Optional<FormActity> optionalFormActity = formActivityRepository.findById(id);
        if(optionalFormActity.isPresent()){
            FormActity form =  optionalFormActity.get();
            form.setVisible(false);
            return formActivityRepository.save(form);
        }else {
            throw new RuntimeException("non trouvé");
        }
    }
    //Débloquer un témoignage
    @PutMapping("/dons/show/{id}")
    FormActity showDons(@PathVariable("id") Long id  ,  @RequestBody FormActity formActity){
        Optional<FormActity> optionalFormActity = formActivityRepository.findById(id);
        if(optionalFormActity.isPresent()){
            FormActity form =  optionalFormActity.get();
            form.setVisible(true);
            return formActivityRepository.save(form);
        }else {
            throw new RuntimeException("non trouvé");
        }
    }

}
