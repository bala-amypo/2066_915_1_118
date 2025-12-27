package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "supplier_risk_alerts")
public class SupplierRiskAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId;

    private String alertLevel;

    private Boolean resolved = false;

    // Constructors
    public SupplierRiskAlert() {}

    public SupplierRiskAlert(Long id, Long supplierId, String alertLevel, Boolean resolved) {
        this.id = id;
        this.supplierId = supplierId;
        this.alertLevel = alertLevel;
        this.resolved = resolved;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }

    public String getAlertLevel() { return alertLevel; }
    public void setAlertLevel(String alertLevel) { this.alertLevel = alertLevel; }

    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }

    // Equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierRiskAlert)) return false;
        SupplierRiskAlert that = (SupplierRiskAlert) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
