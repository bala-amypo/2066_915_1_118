package com.example.demo.service.impl;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

    private final SupplierRiskAlertRepository alertRepository;

    public SupplierRiskAlertServiceImpl(SupplierRiskAlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @Override
    public SupplierRiskAlert createAlert(SupplierRiskAlert alert) {
        return alertRepository.save(alert);
    }

    @Override
    public List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId) {
        return alertRepository.findBySupplierId(supplierId);
    }

    @Override
    public List<SupplierRiskAlert> getAllAlerts() {
        return alertRepository.findAll();
    }
}
