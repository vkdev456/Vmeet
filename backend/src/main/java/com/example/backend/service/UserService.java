package com.example.backend.service;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backend.dto.LoginDto;
import com.example.backend.dto.RegisterDto;
import com.example.backend.entity.User;
import com.example.backend.repository.RegisterationRepo;

@Service
public class UserService {

    @Autowired
    RegisterationRepo regRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void Register(RegisterDto registerDto) {

        // user already exist
        String username = registerDto.getUsername();

        if (regRepo.existsByUsername(username)) {
            throw new RuntimeException("User already Exists");
        }

        User user = new User();

        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        regRepo.save(user);

    }

    public boolean login(LoginDto login) {

        Optional<User> user = regRepo.findByUsername(login.getUsername());

        if (user.isEmpty()) {
            throw new RuntimeException("Invalid username or password");
        }

        User dbUser = user.get();

        if (!passwordEncoder.matches(login.getPassword(), dbUser.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        return true;
    }

}
