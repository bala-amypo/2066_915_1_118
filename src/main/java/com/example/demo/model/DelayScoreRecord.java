package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "delay_score_records", uniqueConstraints = @UniqueConstraint(columnNames = "poId"))
public class DelayScoreRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long supplierId;

    @Column(nullable = false, unique = true)
    private Long poId;

    private Integer delayDays;
    private String delaySeverity;
    private Double score;
    private LocalDateTime computedAt;

    public DelayScoreRecord() {}
    public DelayScoreRecord(Long supplierId, Long poId, Integer delayDays, String delaySeverity, Double score) {
        this.supplierId = supplierId;
        this.poId = poId;
        this.delayDays = delayDays;
        this.delaySeverity = delaySeverity;
        this.score = score;
    }

    @PrePersist
    protected void onCreate() {
        computedAt = LocalDateTime.now();
    }

    // getters & setters
    // ...
}
