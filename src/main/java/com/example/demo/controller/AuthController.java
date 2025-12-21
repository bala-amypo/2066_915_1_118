package com.example.demo.controller;

import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email) {
        // Dummy login response
        if (jwtTokenProvider.validateToken("dummy")) {
            return ResponseEntity.ok("Login successful for: " + email);
        }
        return ResponseEntity.badRequest().body("Invalid credentials");
    }
}
