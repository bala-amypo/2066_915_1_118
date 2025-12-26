package com.example.demo.dto;

public class DelayScoreResponse {
    private Long supplierId;
    private int delayScore;

    // Getters & Setters
    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }
    public int getDelayScore() { return delayScore; }
    public void setDelayScore(int delayScore) { this.delayScore = delayScore; }
}
