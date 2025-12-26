package com.example.demo.service.impl;

import com.example.demo.dto.SupplierRiskResponse;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

    @Override
    public List<SupplierRiskResponse> getOpenAlerts() {
        return new ArrayList<>(); // stub
    }

    @Override
    public void resolveAlert(Long alertId) {
        // stub implementation
    }
}
