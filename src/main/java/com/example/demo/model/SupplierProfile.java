package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Optional;

@Entity
public class SupplierProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean active;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
