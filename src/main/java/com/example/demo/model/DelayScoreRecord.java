package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "delay_scores")
public class DelayScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long poId;

    private Long supplierId;

    private Integer delayDays;

    private String delaySeverity;

    private Double score;

    // Constructors
    public DelayScoreRecord() {}

    public DelayScoreRecord(Long id, Long poId, Long supplierId, Integer delayDays, String delaySeverity, Double score) {
        this.id = id;
        this.poId = poId;
        this.supplierId = supplierId;
        this.delayDays = delayDays;
        this.delaySeverity = delaySeverity;
        this.score = score;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPoId() { return poId; }
    public void setPoId(Long poId) { this.poId = poId; }

    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }

    public Integer getDelayDays() { return delayDays; }
    public void setDelayDays(Integer delayDays) { this.delayDays = delayDays; }

    public String getDelaySeverity() { return delaySeverity; }
    public void setDelaySeverity(String delaySeverity) { this.delaySeverity = delaySeverity; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    // Equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DelayScoreRecord)) return false;
        DelayScoreRecord that = (DelayScoreRecord) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
