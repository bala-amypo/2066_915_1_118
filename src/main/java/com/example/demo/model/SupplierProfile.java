package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "supplier_profiles")
public class SupplierProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String supplierName;
    private String email;
    private String phone;
    private String riskLevel;

    public SupplierProfile() {}

    public SupplierProfile(String supplierName, String email, String phone, String riskLevel) {
        this.supplierName = supplierName;
        this.email = email;
        this.phone = phone;
        this.riskLevel = riskLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}
