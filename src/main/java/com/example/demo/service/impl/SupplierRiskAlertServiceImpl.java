package com.example.demo.service.impl;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

    @Autowired
    private SupplierRiskAlertRepository repository;

    @Override
    public List<SupplierRiskAlert> getAllRiskAlerts() {
        return repository.findAll();
    }

    @Override
    public SupplierRiskAlert getRiskAlertById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public SupplierRiskAlert createRiskAlert(SupplierRiskAlert alert) {
        return repository.save(alert);
    }

    @Override
    public SupplierRiskAlert updateRiskAlert(Long id, SupplierRiskAlert alert) {
        if (repository.existsById(id)) {
            alert.setId(id);
            return repository.save(alert);
        }
        return null;
    }

    @Override
    public void deleteRiskAlert(Long id) {
        repository.deleteById(id);
    }
}
