package com.example.demo.service.impl;

import com.example.demo.dto.DelayScoreResponse;
import com.example.demo.service.DelayScoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    @Override
    public DelayScoreResponse computeDelayScore(Long supplierId) {
        return new DelayScoreResponse(); // stub
    }

    @Override
    public List<DelayScoreResponse> getScoresBySupplier(Long supplierId) {
        return new ArrayList<>(); // stub
    }
}
