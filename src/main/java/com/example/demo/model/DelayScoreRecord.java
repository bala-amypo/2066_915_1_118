package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "delay_scores")
public class DelayScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long purchaseOrderId;

    private Long supplierId;

    private Double score; // delay score value

    public DelayScore() {
    }

    public DelayScore(Long purchaseOrderId, Long supplierId, Double score) {
        this.purchaseOrderId = purchaseOrderId;
        this.supplierId = supplierId;
        this.score = score;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
