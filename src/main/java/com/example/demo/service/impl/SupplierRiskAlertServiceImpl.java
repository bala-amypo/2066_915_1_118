package com.example.demo.service.impl;

import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.stereotype.Service;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

    @Override
    public void resolveAlert(Long id) {
        // dummy implementation
        System.out.println("Resolved alert for supplier id: " + id);
    }
}
