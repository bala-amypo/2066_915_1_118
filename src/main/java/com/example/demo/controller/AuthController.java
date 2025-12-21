package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public AppUser registerUser(@RequestBody AppUser user) {
        return authService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody AppUser user) {
        return authService.loginUser(user);
    }
}
