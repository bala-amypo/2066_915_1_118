package com.example.demo.service;

import com.example.demo.model.AppUser;

public interface AuthService {

    AppUser registerUser(AppUser user);

    String login(String username, String password);
}
