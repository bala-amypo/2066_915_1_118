package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SupplierProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String supplierCode;

    private String name;

    private String contactEmail;

    private LocalDateTime createdAt;

    public SupplierProfile() {}

    public SupplierProfile(Long id, String supplierCode, String name, String contactEmail, LocalDateTime createdAt) {
        this.id = id;
        this.supplierCode = supplierCode;
        this.name = name;
        this.contactEmail = contactEmail;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSupplierCode() { return supplierCode; }
    public void setSupplierCode(String supplierCode) { this.supplierCode = supplierCode; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
