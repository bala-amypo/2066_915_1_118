package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
}