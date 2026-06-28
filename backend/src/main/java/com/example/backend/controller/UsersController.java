package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
=======
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
>>>>>>> Stashed changes
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend.dto.LoginDto;
import com.example.backend.dto.RegisterDto;
import com.example.backend.service.UserService;

import jakarta.validation.Valid;

import com.example.backend.dto.RegisterDto;

import jakarta.validation.Valid;

@RestController
public class UsersController {

<<<<<<< Updated upstream
    @Autowired
    private RegisterService register ;
=======

    @Autowired
    UserService userService;

>>>>>>> Stashed changes

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto login){

        try{
            userService.login(login);
            return ResponseEntity.status(HttpStatus.OK).body("Login Successfull");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage()); 
        }
        
    } 

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDto register){
<<<<<<< Updated upstream
              
=======

        try{
           userService.Register(register);
            return ResponseEntity.status(HttpStatus.CREATED).body("User added");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());    
        }
           
>>>>>>> Stashed changes
    }

    @PostMapping("/add_to_activity")
    public void AddToActivity(String str){
           
    }
    
    @GetMapping("get_all_activity")
<<<<<<< Updated upstream
    public String getAllAcitvity(){
        return "Hello";
=======
    public void getAllAcitvity(){
        
>>>>>>> Stashed changes
    }

}
