package com.example.demo.service.impl;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.NoSuchElementException;

@Service
@Transactional
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {
    @Autowired private SupplierRiskAlertRepository repository;

    @Override
    public SupplierRiskAlert saveAlert(SupplierRiskAlert alert) {
        if (alert.getResolved() == null) alert.setResolved(false);
        return repository.saveAndFlush(alert);
    }

    @Override
    public SupplierRiskAlert resolveAlert(Long id) {
        SupplierRiskAlert alert = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No value present"));
        alert.setResolved(true);
        return repository.saveAndFlush(alert);
    }
}