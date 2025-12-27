package com.example.demo.controller;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/risk-alert")
public class SupplierRiskAlertController {

    @Autowired
    private SupplierRiskAlertService riskAlertService;

    @PostMapping("/create")
    public SupplierRiskAlert createAlert(@RequestBody SupplierRiskAlert alert) {
        return riskAlertService.createAlert(alert);
    }

    @PutMapping("/resolve/{id}")
    public SupplierRiskAlert resolveAlert(@PathVariable Long id) {
        return riskAlertService.resolveAlert(id);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<SupplierRiskAlert> getAlertsBySupplier(@PathVariable Long supplierId) {
        return riskAlertService.getAlertsBySupplier(supplierId);
    }

    @GetMapping("/all")
    public List<SupplierRiskAlert> getAllAlerts() {
        return riskAlertService.getAllAlerts();
    }
}
