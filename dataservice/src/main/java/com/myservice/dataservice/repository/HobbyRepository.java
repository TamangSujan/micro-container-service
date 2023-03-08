package com.myservice.dataservice.repository;

import com.myservice.dataservice.model.Hobby;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class HobbyRepository {
    private List<Hobby> list;
    private int size;
    public HobbyRepository(){
        list = new ArrayList<>(List.of(
                new Hobby(1, 1, "Basketball"),
                new Hobby(2, 2, "Basketball"),
                new Hobby(3, 3, "Chess"),
                new Hobby(4, 3, "Football"),
                new Hobby(5, 3, "Hockey"),
                new Hobby(6, 2, "Chess"),
                new Hobby(7, 1, "Football"),
                new Hobby(8, 2, "Tennis"),
                new Hobby(9, 2, "Computer")
        ));
        size = list.size();
    }

    public List<Hobby> findHobbiesById(int id){
        return list.stream().filter(hobby -> hobby.getUserId()==id)
                .collect(Collectors.toList());
    }

    public Hobby save(Hobby hobby){
        hobby.setId(++size);
        list.add(hobby);
        return hobby;
    }
}
