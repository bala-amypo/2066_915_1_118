package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "supplier_risk_alerts")
@Data
@NoArgsConstructor
public class SupplierRiskAlert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long supplierId;
    private String alertLevel;
    private String message;
    private LocalDateTime alertDate;
    private Boolean resolved = false;

    // Parameterized constructor used by DelayScoreServiceImpl
    public SupplierRiskAlert(Long supplierId, String alertLevel, String message) {
        this.supplierId = supplierId;
        this.alertLevel = alertLevel;
        this.message = message;
        this.alertDate = LocalDateTime.now();
        this.resolved = false;
    }

    @PrePersist
    protected void onCreate() {
        if (alertDate == null) alertDate = LocalDateTime.now();
        if (resolved == null) resolved = false;
    }
}