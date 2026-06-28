package com.example.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
<<<<<<< Updated upstream
@Table(name="users")
=======
@Table(name = "users")
>>>>>>> Stashed changes
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< Updated upstream
    private Long Id;
=======
    private Long id;

>>>>>>> Stashed changes

    @NotNull
    private String name;
    
    @NotNull
    private String username;

    @NotNull
    private String password;

<<<<<<< Updated upstream
    @NotNull
=======
   
  
>>>>>>> Stashed changes
    private String token;

    public User(){}


    public Long getId(){
<<<<<<< Updated upstream
        return Id;
    }

    public void SetId(Long id){
        this.Id=id;
=======
        return id;
    }

    public void SetId(Long id){
        this.id=id;
>>>>>>> Stashed changes
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
