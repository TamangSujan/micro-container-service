package com.myservice.viewservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hobby {
    private int id;
    private int userId;
    private String name;
}
