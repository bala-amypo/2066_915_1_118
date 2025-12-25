package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider tokenProvider;

    public AuthServiceImpl(
            AppUserRepository userRepo,
            PasswordEncoder encoder,
            JwtTokenProvider tokenProvider) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void register(RegisterRequest request) {

        if (userRepo.existsByUsername(request.getUsername())) {
            throw new BadRequestException("Username already exists");
        }

        if (userRepo.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        AppUser user = new AppUser();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userRepo.save(user);
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        AppUser user = userRepo.findAll()
                .stream()
                .filter(u -> u.getUsername().equals(request.getUsername()))
                .findFirst()
                .orElseThrow(() ->
                        new BadRequestException("Invalid credentials"));

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        String token = tokenProvider.generateToken(user.getUsername());
        return new AuthResponse(token);
    }
}
