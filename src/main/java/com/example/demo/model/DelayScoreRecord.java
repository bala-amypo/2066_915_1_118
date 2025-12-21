package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DelayScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId;
    private Long poId;
    private int delayDays;
    private String delaySeverity;
    private double score;

    public DelayScoreRecord() {}

    // ✅ REQUIRED CONSTRUCTOR
    public DelayScoreRecord(Long supplierId, Long poId, int delayDays,
                            String delaySeverity, double score) {
        this.supplierId = supplierId;
        this.poId = poId;
        this.delayDays = delayDays;
        this.delaySeverity = delaySeverity;
        this.score = score;
    }

    public Long getId() { return id; }
    public Long getSupplierId() { return supplierId; }
    public Long getPoId() { return poId; }
    public int getDelayDays() { return delayDays; }
    public String getDelaySeverity() { return delaySeverity; }
    public double getScore() { return score; }
}
