package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SupplierProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String supplierCode;

    private String supplierName;

    private String contactNumber;

    public SupplierProfile() {
    }

    public SupplierProfile(Long id, String supplierCode, String supplierName, String contactNumber) {
        this.id = id;
        this.supplierCode = supplierCode;
        this.supplierName = supplierName;
        this.contactNumber = contactNumber;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSupplierCode() { return supplierCode; }
    public void setSupplierCode(String supplierCode) { this.supplierCode = supplierCode; }

    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}
