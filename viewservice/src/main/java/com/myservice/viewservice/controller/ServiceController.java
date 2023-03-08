package com.myservice.viewservice.controller;

import com.myservice.viewservice.model.AppUser;
import com.myservice.viewservice.model.Hobby;
import com.myservice.viewservice.route.Routes;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@AllArgsConstructor
public class ServiceController {
    private RestTemplate restTemplate;
    private Routes routes;

    @GetMapping("/")
    public ResponseEntity<String> test(){
        return ResponseEntity.status(HttpStatus.OK).body("Test");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable(name = "id") int id){
        ResponseEntity<AppUser> response = restTemplate.getForEntity(routes.getLoginRoute()+"/user/"+id, AppUser.class);
        return response;
    }

    @PostMapping("/user")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser appUser){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<AppUser> entity = new HttpEntity(appUser, headers);
        ResponseEntity<AppUser> response = restTemplate.postForEntity(routes.getLoginRoute()+"/user", entity, AppUser.class);
        return response;
    }

    @GetMapping("/hobby/{id}")
    public ResponseEntity<List<Hobby>> getHobbiesById(@PathVariable(name = "id") int id){
        ResponseEntity<List<Hobby>> response = restTemplate.exchange(routes.getDataRoute()+"/hobby/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<List<Hobby>>() {});
        return response;
    }

    @PostMapping("/hobby")
    public ResponseEntity<Hobby> addHobby(@RequestBody Hobby hobby){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<AppUser> entity = new HttpEntity(hobby, headers);
        ResponseEntity<Hobby> response = restTemplate.postForEntity(routes.getDataRoute()+"/hobby", entity, Hobby.class);
        return response;
    }
}
