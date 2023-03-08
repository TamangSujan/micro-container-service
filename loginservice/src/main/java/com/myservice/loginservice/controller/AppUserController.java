package com.myservice.loginservice.controller;

import com.myservice.loginservice.model.AppUser;
import com.myservice.loginservice.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class AppUserController {
    private AppUserRepository appUserRepository;

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable(name = "id")int id){
        return ResponseEntity.status(HttpStatus.OK).body(appUserRepository.findByUserid(id));
    }

    @PostMapping
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser appUser){
        return ResponseEntity.status(HttpStatus.OK).body(appUserRepository.save(appUser));
    }
}
