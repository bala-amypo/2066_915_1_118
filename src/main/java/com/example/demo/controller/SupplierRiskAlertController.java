package com.example.demo.controller;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class SupplierRiskAlertController {

    private final SupplierRiskAlertService alertService;

    public SupplierRiskAlertController(SupplierRiskAlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping("/open")
    public List<SupplierRiskAlert> openAlerts() {
        return alertService.getOpenAlerts();
    }

    @PutMapping("/{id}/resolve")
    public SupplierRiskAlert resolve(@PathVariable Long id) {
        return alertService.resolveAlert(id);
    }
}
