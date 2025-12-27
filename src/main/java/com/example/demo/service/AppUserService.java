package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.AppUser;

public interface AppUserService {

    String registerUser(RegisterRequest request);

    String loginUser(LoginRequest request);
}
