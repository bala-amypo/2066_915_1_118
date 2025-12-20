package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.security.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenProvider tokenProvider;
    private final PasswordEncoder encoder;
    private final AppUserRepository repository;

    public AuthController(CustomUserDetailsService userDetailsService,
                          JwtTokenProvider tokenProvider,
                          PasswordEncoder encoder,
                          AppUserRepository repository) {
        this.userDetailsService = userDetailsService;
        this.tokenProvider = tokenProvider;
        this.encoder = encoder;
        this.repository = repository;
    }

    @PostMapping("/register")
    public AppUser register(@RequestBody RegisterRequest request) {
        AppUser user = new AppUser(
                request.getEmail(),
                encoder.encode(request.getPassword()),
                request.getRole()
        );
        return repository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        AppUser user = repository.findByEmail(request.getEmail()).orElseThrow();
        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return tokenProvider.generateToken(user);
    }
}
