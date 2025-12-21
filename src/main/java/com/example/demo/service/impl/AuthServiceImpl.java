package com.example.demo.service.impl;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AppUserRepository userRepository;

    @Override
    public AppUser registerUser(AppUser user) {
        return userRepository.save(user);
    }

    @Override
    public String loginUser(AppUser user) {
        // Basic login check (for demo, you can replace with proper authentication)
        AppUser existing = userRepository.findByUsername(user.getUsername());
        if (existing != null && existing.getPassword().equals(user.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }
}
