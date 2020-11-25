package com.springboot.demo.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {
    private String name;
    private UUID id;
    private Gender gender;

    public User() {
    }

    public User(String name, UUID id, Gender gender) {
        this.name = name;
        this.id = id;
        this.gender = gender;
    }
}
