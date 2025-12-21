package com.example.demo.service.impl;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository repository;

    public AuthServiceImpl(AppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public AppUser registerUser(AppUser user) {
        user.setCreatedAt(LocalDateTime.now());
        return repository.save(user);
    }

    @Override
    public String login(String username, String password) {
        AppUser user = repository.findByEmail(username).orElse(null);
        if (user != null && user.getPassword().equals(password)) {
            return "LOGIN SUCCESS";
        }
        return "INVALID CREDENTIALS";
    }
}
