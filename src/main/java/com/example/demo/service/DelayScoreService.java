package com.example.demo.service;

import com.example.demo.model.DelayScore;
import java.util.List;

public interface DelayScoreService {
    void calculateDelayScore();
    DelayScore computeDelayScore(Long purchaseOrderId);
    List<DelayScore> getScoresBySupplier(Long supplierId);
    List<DelayScore> getAllScores();
}
