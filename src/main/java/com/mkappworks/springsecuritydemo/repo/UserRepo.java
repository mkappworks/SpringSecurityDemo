package com.mkappworks.springsecuritydemo.repo;

import com.mkappworks.springsecuritydemo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
