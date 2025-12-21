package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DelayScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer score;

    private String description;

    public DelayScore() {
    }

    public DelayScore(Long id, Integer score, String description) {
        this.id = id;
        this.score = score;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
