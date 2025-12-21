package com.example.demo.service;

import com.example.demo.model.DelayScore;

import java.util.List;

public interface DelayScoreService {
    void calculateDelayScore();
    List<DelayScore> getAllScores();
    List<DelayScore> getScoresBySupplier(Long supplierId);
}
