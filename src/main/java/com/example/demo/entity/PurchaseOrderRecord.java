package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PurchaseOrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;

    private Double amount;

    private LocalDateTime orderDate;

    public PurchaseOrderRecord() {}

    public PurchaseOrderRecord(Long id, String orderNumber, Double amount, LocalDateTime orderDate) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.amount = amount;
        this.orderDate = orderDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
}
