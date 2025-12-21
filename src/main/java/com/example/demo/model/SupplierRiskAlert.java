package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SupplierRiskAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId;
    private String alertLevel;
    private String message;
    private boolean resolved = false;

    public SupplierRiskAlert() {}

    // ✅ REQUIRED CONSTRUCTOR
    public SupplierRiskAlert(Long supplierId, String alertLevel, String message) {
        this.supplierId = supplierId;
        this.alertLevel = alertLevel;
        this.message = message;
        this.resolved = false;
    }

    public Long getId() { return id; }
    public Long getSupplierId() { return supplierId; }
    public String getAlertLevel() { return alertLevel; }
    public String getMessage() { return message; }
    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
