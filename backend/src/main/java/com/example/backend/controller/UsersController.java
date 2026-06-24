package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.RegisterDto;

import jakarta.validation.Valid;

@RestController
public class UsersController {

    @Autowired
    private RegisterService register ;

    @PostMapping("/login")
    public void getUser(){
        
    } 

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDto register){
              
    }

    @PostMapping("/add_to_activity")
    public void AddToActivity(String str){
           
    }
    
    @GetMapping("get_all_activity")
    public String getAllAcitvity(){
        return "Hello";
    }

}
