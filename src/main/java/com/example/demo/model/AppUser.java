package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // This generates getUsername(), getPassword(), getRole()
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;
}