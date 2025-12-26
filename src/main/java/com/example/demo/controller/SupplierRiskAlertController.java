package com.example.demo.controller;

import com.example.demo.dto.SupplierRiskResponse;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class SupplierRiskAlertController {

    @Autowired
    private SupplierRiskAlertService alertService;

    @GetMapping("/open")
    public List<SupplierRiskResponse> getOpenAlerts() {
        return alertService.getOpenAlerts();
    }

    @PostMapping("/resolve/{id}")
    public void resolveAlert(@PathVariable Long id) {
        alertService.resolveAlert(id);
    }
}
