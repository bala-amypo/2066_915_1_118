package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SupplierRiskAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String supplierCode;

    private String alertMessage;

    private LocalDateTime alertDate;

    public SupplierRiskAlert() {}

    public SupplierRiskAlert(Long id, String supplierCode, String alertMessage, LocalDateTime alertDate) {
        this.id = id;
        this.supplierCode = supplierCode;
        this.alertMessage = alertMessage;
        this.alertDate = alertDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSupplierCode() { return supplierCode; }
    public void setSupplierCode(String supplierCode) { this.supplierCode = supplierCode; }

    public String getAlertMessage() { return alertMessage; }
    public void setAlertMessage(String alertMessage) { this.alertMessage = alertMessage; }

    public LocalDateTime getAlertDate() { return alertDate; }
    public void setAlertDate(LocalDateTime alertDate) { this.alertDate = alertDate; }
}
