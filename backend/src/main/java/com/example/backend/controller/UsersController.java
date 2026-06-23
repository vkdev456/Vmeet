package com.example.backend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @PostMapping("/login")
    public void getUser(){
        
    }

    @PostMapping("/register")
    public void registe(String str){
        
    }

    @PostMapping("/add_to_activity")
    public void AddToActivity(String str){
           
    }
    
    @GetMapping("get_all_activity")
    public void getAllAcitvity(){
          
    
    }

}
