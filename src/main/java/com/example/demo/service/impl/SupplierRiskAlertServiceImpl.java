package com.example.demo.service.impl;
import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {
    private final SupplierRiskAlertRepository repository;
    public SupplierRiskAlertServiceImpl(SupplierRiskAlertRepository repository) { this.repository = repository; }

    public SupplierRiskAlert createAlert(SupplierRiskAlert a) {
        if (a.getResolved() == null) a.setResolved(false);
        return repository.save(a);
    }
    public List<SupplierRiskAlert> getAlertsBySupplier(Long id) { return repository.findBySupplierId(id); }
    public List<SupplierRiskAlert> getAllAlerts() { return repository.findAll(); }
    public SupplierRiskAlert resolveAlert(Long id) {
        SupplierRiskAlert a = repository.findById(id).orElseThrow();
        a.setResolved(true);
        return repository.save(a);
    }
}