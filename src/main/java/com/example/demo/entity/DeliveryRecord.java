package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DeliveryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deliveryNumber;

    private String status;

    private LocalDateTime deliveryDate;

    public DeliveryRecord() {}

    public DeliveryRecord(Long id, String deliveryNumber, String status, LocalDateTime deliveryDate) {
        this.id = id;
        this.deliveryNumber = deliveryNumber;
        this.status = status;
        this.deliveryDate = deliveryDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDeliveryNumber() { return deliveryNumber; }
    public void setDeliveryNumber(String deliveryNumber) { this.deliveryNumber = deliveryNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(LocalDateTime deliveryDate) { this.deliveryDate = deliveryDate; }
}
