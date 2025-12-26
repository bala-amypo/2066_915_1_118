package com.example.demo.service;

import com.example.demo.dto.DelayScoreResponse;
import java.util.List;

public interface DelayScoreService {
    DelayScoreResponse computeDelayScore(Long supplierId);
    List<DelayScoreResponse> getScoresBySupplier(Long supplierId);
}
