package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierRiskAlertService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

    @Autowired
    private SupplierProfileRepository supplierRepo;

    @Override
    public List<String> generateRiskAlerts() {
        List<String> alerts = new ArrayList<>();
        List<SupplierProfile> suppliers = supplierRepo.findAll();

        for (SupplierProfile supplier : suppliers) {
            if (!supplier.getActive()) {
                alerts.add("Supplier inactive: " + supplier.getName());
            }
        }
        return alerts;
    }
}
