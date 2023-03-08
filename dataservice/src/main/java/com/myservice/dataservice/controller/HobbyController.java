package com.myservice.dataservice.controller;

import com.myservice.dataservice.model.Hobby;
import com.myservice.dataservice.repository.HobbyRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/hobby")
public class HobbyController {
    private HobbyRepository hobbyRepository;

    @GetMapping("/{id}")
    public ResponseEntity<List<Hobby>> getAllHobbyByUser(@PathVariable(name = "id")int id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(hobbyRepository.findHobbiesById(id));
    }

    @PostMapping
    public ResponseEntity<Hobby> saveHobby(@RequestBody Hobby hobby){
        return ResponseEntity.status(HttpStatus.OK).body(hobbyRepository.save(hobby));
    }
}
