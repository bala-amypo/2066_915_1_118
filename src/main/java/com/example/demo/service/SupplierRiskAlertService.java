package com.example.demo.service;

import com.example.demo.model.SupplierRiskAlert;

import java.util.List;

public interface SupplierRiskAlertService {
    List<SupplierRiskAlert> getAllRiskAlerts();
    SupplierRiskAlert getRiskAlertById(Long id);
    SupplierRiskAlert createRiskAlert(SupplierRiskAlert alert);
    SupplierRiskAlert updateRiskAlert(Long id, SupplierRiskAlert alert);
    void deleteRiskAlert(Long id);
}
