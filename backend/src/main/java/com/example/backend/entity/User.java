package com.example.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long id;

    @NotNull
    private String name;
    
    @NotNull
    private String username;

    @NotNull
    private String password;

    private String token;

    public User(){}

    public Long getId(){
        return id;
    }

    public void SetId(Long id){
        this.id=id;
        return Id;
    }

    public void SetId(Long id){
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
