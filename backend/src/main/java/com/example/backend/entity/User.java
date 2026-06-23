package com.example.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;


    @NotNull
    private String name;
    
    
    @NotNull
    private String username;

    @NotNull
    private String password;

   
    @NotNull
    private String token;


    public User(){}


    public String getId(){
        return Id;
    }

    public void SetId(String id){
        this.Id=id;
    }

    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getToken() {
        return token;
    }


    public void setToken(String token) {
        this.token = token;
    }
    
}
