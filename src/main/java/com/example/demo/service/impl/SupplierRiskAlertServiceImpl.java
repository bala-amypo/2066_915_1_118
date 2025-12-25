package com.example.demo.service.impl;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;
import com.example.demo.service.SupplierRiskAlertService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

    private final SupplierRiskAlertRepository alertRepo;

    public SupplierRiskAlertServiceImpl(SupplierRiskAlertRepository alertRepo) {
        this.alertRepo = alertRepo;
    }

    @Override
    public SupplierRiskAlert raiseRiskAlert(Long supplierId, String level, String message) {
        SupplierRiskAlert alert = new SupplierRiskAlert();
        alert.setSupplierId(supplierId);
        alert.setAlertLevel(level);
        alert.setMessage(message);
        alert.setResolved(false);
        return alertRepo.save(alert);
    }

    @Override
    public List<SupplierRiskAlert> getOpenAlerts() {
        return alertRepo.findByResolvedFalse();
    }

    @Override
    public SupplierRiskAlert resolveAlert(Long alertId) {
        SupplierRiskAlert alert = alertRepo.findById(alertId)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
        alert.setResolved(true);
        return alertRepo.save(alert);
    }
}
