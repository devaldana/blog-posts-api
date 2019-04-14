package com.devspods.controllers;

import com.devspods.domain.Gender;
import com.devspods.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/genders")
public class GenderController {

    private GenderService genderService;

    @Autowired
    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping
    public List<Gender> findAll(){
        return this.genderService.findAll();
    }

    @PostMapping
    public ResponseEntity<Gender> save(@RequestBody @NotNull @Valid Gender gender) {
        Gender savedGender = this.genderService.save(gender);
        return ResponseEntity.status(CREATED).body(savedGender);
    }
}
