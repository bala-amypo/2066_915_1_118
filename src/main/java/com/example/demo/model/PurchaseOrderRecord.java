package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseOrderRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long supplierId;
    private String productName;
    private int quantity;
    private LocalDate promisedDeliveryDate;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public LocalDate getPromisedDeliveryDate() { return promisedDeliveryDate; }
    public void setPromisedDeliveryDate(LocalDate promisedDeliveryDate) { this.promisedDeliveryDate = promisedDeliveryDate; }
}
