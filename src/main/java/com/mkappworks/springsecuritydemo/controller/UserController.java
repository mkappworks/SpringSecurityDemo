package com.mkappworks.springsecuritydemo.controller;

import com.mkappworks.springsecuritydemo.model.Users;
import com.mkappworks.springsecuritydemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public Users register(@RequestBody Users user) {
        return userService.createUser(user);
    }

    @PostMapping("login")
    public String login(@RequestBody Users user) {
        return userService.verify(user);
    }
}
