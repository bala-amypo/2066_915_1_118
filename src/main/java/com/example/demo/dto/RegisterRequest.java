package com.example.demo.dto;

import com.example.demo.model.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private Role role;
}