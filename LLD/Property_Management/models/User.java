package models;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    String id;
    String name;
    String address;

    public User(String id, String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}