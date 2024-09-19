package com.mkappworks.springsecuritydemo.service;

import com.mkappworks.springsecuritydemo.model.Users;
import com.mkappworks.springsecuritydemo.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    final private UserRepo userRepo;
    final private AuthenticationManager authenticationManager;
    final private JwtService jwtService;

    final private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

    public Users createUser(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String verify(Users user) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (auth.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        else
            return "Login Failed";
    }


}
