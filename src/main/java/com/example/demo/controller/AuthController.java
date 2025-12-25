package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final AppUserRepository appUserRepository;

    public AuthController(CustomUserDetailsService userDetailsService,
                          JwtTokenProvider jwtTokenProvider,
                          PasswordEncoder passwordEncoder,
                          AppUserRepository appUserRepository) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.appUserRepository = appUserRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (appUserRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Email already exists"));
        }
        AppUser user = new AppUser(request.getEmail(), passwordEncoder.encode(request.getPassword()), request.getRole());
        AppUser saved = appUserRepository.save(user);
        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully", saved));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        AppUser user = (AppUser) userDetailsService.loadUserByUsername(request.getEmail());
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Invalid credentials"));
        }
        String token = jwtTokenProvider.generateToken(user);
        return ResponseEntity.ok(new ApiResponse(true, "Login successful", token));
    }
}
