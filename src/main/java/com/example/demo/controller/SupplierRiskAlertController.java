package com.example.demo.controller;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-alerts")
public class SupplierRiskAlertController {

    @Autowired
    private SupplierRiskAlertService service;

    @GetMapping
    public List<SupplierRiskAlert> getAllRiskAlerts() {
        return service.getAllRiskAlerts();
    }

    @GetMapping("/{id}")
    public SupplierRiskAlert getRiskAlertById(@PathVariable Long id) {
        return service.getRiskAlertById(id);
    }

    @PostMapping
    public SupplierRiskAlert createRiskAlert(@RequestBody SupplierRiskAlert alert) {
        return service.createRiskAlert(alert);
    }

    @PutMapping("/{id}")
    public SupplierRiskAlert updateRiskAlert(@PathVariable Long id, @RequestBody SupplierRiskAlert alert) {
        return service.updateRiskAlert(id, alert);
    }

    @DeleteMapping("/{id}")
    public void deleteRiskAlert(@PathVariable Long id) {
        service.deleteRiskAlert(id);
    }
}
