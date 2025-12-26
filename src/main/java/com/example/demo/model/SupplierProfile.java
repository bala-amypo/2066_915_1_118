package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SupplierProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean active;

    public SupplierProfile() {}

    public SupplierProfile(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
