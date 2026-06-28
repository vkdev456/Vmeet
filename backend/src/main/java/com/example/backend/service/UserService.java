package com.example.backend.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dto.LoginDto;
import com.example.backend.dto.RegisterDto;
import com.example.backend.entity.User;
import com.example.backend.repository.RegisterationRepo;

@Service
public class UserService {

    @Autowired
    RegisterationRepo regRepo;

    public void Register(RegisterDto registerDto) {

        // user already exist
        String username = registerDto.getUsername();

        if (regRepo.existsByUsername(username)) {
            throw new RuntimeException("User already Exists");
        }

        User user = new User();

        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setPassword(registerDto.getPassword());

        regRepo.save(user);

    }

    public boolean login(LoginDto login){
        
        String username=login.getUsername();
        if(regRepo.existsByUsername(username)){
            return true;
        }else{
            throw new RuntimeException("User doesnot Exist please login");
        }
    }

}
