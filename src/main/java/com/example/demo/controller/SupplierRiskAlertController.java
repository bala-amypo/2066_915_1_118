package com.example.demo.controller;

import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/risk")
public class SupplierRiskAlertController {

    private final SupplierRiskAlertService supplierRiskAlertService;

    public SupplierRiskAlertController(SupplierRiskAlertService supplierRiskAlertService) {
        this.supplierRiskAlertService = supplierRiskAlertService;
    }

    @PostMapping("/resolve/{id}")
    public ResponseEntity<String> resolveAlert(@PathVariable Long id) {
        supplierRiskAlertService.resolveAlert(id); // dummy implementation
        return ResponseEntity.ok("Alert resolved for ID: " + id);
    }
}
