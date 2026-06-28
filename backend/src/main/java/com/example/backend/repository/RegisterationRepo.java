package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.backend.entity.*;

@Repository
public interface RegisterationRepo extends JpaRepository<User,Long>{
     boolean existsByUsername(String username);
}
