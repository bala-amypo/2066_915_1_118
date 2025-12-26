package com.example.demo.controller;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.service.SupplierRiskAlertService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/risk-alerts")
@Tag(name = "Risk Alerts")
public class SupplierRiskAlertController {
    
    private final SupplierRiskAlertService riskAlertService;
    
    public SupplierRiskAlertController(SupplierRiskAlertService riskAlertService) {
        this.riskAlertService = riskAlertService;
    }
    
    @PostMapping
    @Operation(summary = "Create risk alert")
    public ResponseEntity<SupplierRiskAlert> createAlert(@RequestBody SupplierRiskAlert alert) {
        SupplierRiskAlert created = riskAlertService.createAlert(alert);
        return ResponseEntity.ok(created);
    }
    
    @GetMapping("/supplier/{supplierId}")
    @Operation(summary = "Get alerts by supplier")
    public ResponseEntity<List<SupplierRiskAlert>> getAlertsBySupplier(@Parameter(name = "supplierId") @PathVariable Long supplierId) {
        List<SupplierRiskAlert> alerts = riskAlertService.getAlertsBySupplier(supplierId);
        return ResponseEntity.ok(alerts);
    }
    
    @PutMapping("/{id}/resolve")
    @Operation(summary = "Resolve alert")
    public ResponseEntity<SupplierRiskAlert> resolveAlert(@Parameter(name = "id") @PathVariable Long id) {
        SupplierRiskAlert resolved = riskAlertService.resolveAlert(id);
        return ResponseEntity.ok(resolved);
    }
    
    @GetMapping
    @Operation(summary = "Get all alerts")
    public ResponseEntity<List<SupplierRiskAlert>> getAllAlerts() {
        List<SupplierRiskAlert> alerts = riskAlertService.getAllAlerts();
        return ResponseEntity.ok(alerts);
    }
}