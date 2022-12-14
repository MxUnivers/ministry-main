package com.ministry.fullness.bodyChrist.controller;

import com.ministry.fullness.bodyChrist.entity.FormActity;
import com.ministry.fullness.bodyChrist.repository.FormActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.Optional;


@Controller
@RequestMapping("/api/v1/formactivity")
public class FormActivityController {
    @Autowired
    FormActivityRepository formActivityRepository;

    @PostMapping("/")
    public FormActity createactivity (@RequestBody FormActity newActivity){
        return formActivityRepository.save(newActivity);
    }
    @PutMapping("/{id}")
    FormActity updateFormActvity(@PathVariable("id") Long id  ,  @RequestBody FormActity formActity){
        Optional<FormActity> optionalFormActity = formActivityRepository.findById(id);
        if(optionalFormActity.isPresent()){
            FormActity form =  optionalFormActity.get();
            form.setContent(form.getContent());
            form.setCoverPicture(form.getCoverPicture());
            form.setDescription(form.getCoverPicture());
            form.setTitle(form.getTitle());
            form.setTypeform(form.getTypeform());
            form.setContent(form.getContent());
            form.setContent(form.getContent());
            return formActivityRepository.save(form);
        }else {
            throw new RuntimeException("non trouvé");
        }
    }

    @PatchMapping("hide/{id}")
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
    @PatchMapping("show/{id}")
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
}
