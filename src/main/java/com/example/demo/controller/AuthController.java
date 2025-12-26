package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
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
    @Operation(summary = "Register new user")
    public ResponseEntity<AppUser> register(@RequestBody RegisterRequest request) {
        AppUser user = new AppUser();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        if (request.getUsername() != null) {
            user.setUsername(request.getUsername());
        }
        AppUser saved = appUserRepository.save(user);
        return ResponseEntity.ok(saved);
    }
    
    @PostMapping("/login")
    @Operation(summary = "Login user")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String identifier = request.getUsername() != null ? request.getUsername() : request.getEmail();
        UserDetails userDetails = userDetailsService.loadUserByUsername(identifier);
        
        if (passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
            AppUser user = appUserRepository.findByEmail(identifier)
                .or(() -> appUserRepository.findByUsername(identifier))
                .orElseThrow();
            String token = jwtTokenProvider.generateToken(user);
            return ResponseEntity.ok(token);
        }
        
        return ResponseEntity.badRequest().build();
    }
}demo/src/main/resources