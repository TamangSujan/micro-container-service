package com.myservice.loginservice.repository;

import com.myservice.loginservice.model.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppUserRepository {
    private List<AppUser> list;
    private int size;

    public AppUserRepository(){
        list = new ArrayList<>(List.of(
                new AppUser(1, "sujanmoktan", "Sujan", "sujanmoktan@gmail.com"),
                new AppUser(1, "ayushtimalsina", "Ayush", "ayushtimalsina@gmail.com"),
                new AppUser(1, "suzankc", "Suzan", "suzankc@gmail.com")
        ));
        size = list.size();
    }

    public AppUser findByUserid(int id){
        return list.stream().filter(appUser -> appUser.getId()==id)
                .findFirst().get();
    }

    public AppUser save(AppUser user){
        user.setId(++size);
        list.add(user);
        return user;
    }

}
