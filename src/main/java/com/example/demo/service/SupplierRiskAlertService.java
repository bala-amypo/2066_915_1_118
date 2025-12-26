package com.example.demo.service;

import com.example.demo.dto.SupplierRiskResponse;
import java.util.List;

public interface SupplierRiskAlertService {
    List<SupplierRiskResponse> getOpenAlerts();
    void resolveAlert(Long alertId);
}
