package com.stackroute.Soulmate.controller;

import com.stackroute.Soulmate.exception.SoulmateAlreadyExistException;
import com.stackroute.Soulmate.exception.SoulmateNotFoundException;
import com.stackroute.Soulmate.model.Soulmate;
import com.stackroute.Soulmate.service.SoulmateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SoulmateController {

    private SoulmateService soulmateService;

    @Autowired
    public SoulmateController(SoulmateService soulmateService) {
        this.soulmateService = soulmateService;
    }

    @PostMapping("/soulmate")
    public ResponseEntity<Soulmate> addProfile(@RequestBody Soulmate soulmate) throws SoulmateAlreadyExistException {
        return new ResponseEntity<>(soulmateService.addProfile(soulmate) , HttpStatus.CREATED);
    }

    @DeleteMapping("/soulmate/{id}")
    public ResponseEntity<Soulmate> delProfile(@PathVariable int id) throws SoulmateNotFoundException {
        return new ResponseEntity<>(soulmateService.deleteProfile(id) , HttpStatus.OK);
    }

    @PutMapping("/soulmate")
    public ResponseEntity<Soulmate> updateProfile(@RequestBody Soulmate soulmate ) throws SoulmateNotFoundException {
        return new ResponseEntity<>(soulmateService.updateProfile(soulmate) , HttpStatus.OK);
    }

    @GetMapping("/soulmates")
    public ResponseEntity<List<Soulmate>> getAllProfile(){
        return new ResponseEntity<>(soulmateService.getAllProfile() , HttpStatus.OK);
    }

    @GetMapping("/soulmate/{name}")
    public ResponseEntity<Soulmate> getSoulmateByName(@PathVariable String name) throws SoulmateNotFoundException {
        return new ResponseEntity (soulmateService.getListByName(name) , HttpStatus.FOUND);
    }


    @GetMapping("/soulmate/{gender}/{age}")
    public ResponseEntity<Soulmate> getSoulmateByAge(@PathVariable String gender , @PathVariable int age) throws SoulmateNotFoundException {
        return new ResponseEntity (soulmateService.getListByGenderAndAge(gender, age) , HttpStatus.FOUND);
    }
}
