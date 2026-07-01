package com.example.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend.dto.LoginDto;
import com.example.backend.dto.RegisterDto;
import com.example.backend.service.JwtService;
import com.example.backend.service.UserService;

import jakarta.validation.Valid;

import com.example.backend.dto.RegisterDto;


import jakarta.validation.Valid;

@RestController
public class UsersController {


    @Autowired
    private UserService userService;
    
    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto login){

        try{
            userService.login(login);
            String token = userService.login(login);
            // return ResponseEntity.ok(token);
            return ResponseEntity.status(HttpStatus.OK).body( Map.of(
        "message", "Login Successful",
        "token", token
        ));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
        
    } 

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDto register){

        try{
           userService.Register(register);
            return ResponseEntity.status(HttpStatus.CREATED).body("User added");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());    
        }
           
    }

    @PostMapping("/add_to_activity")
    public void AddToActivity(String str){

    }

    @GetMapping("get_all_activity")
    public void getAllAcitvity(){
        

    }

}
