package com.example.demo.controller;

import com.example.demo.entity.SupplierRiskAlert;
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

    @GetMapping
    public List<SupplierRiskAlert> getAll() {
        return alertService.getAll();
    }

    @PostMapping
    public SupplierRiskAlert create(@RequestBody SupplierRiskAlert alert) {
        return alertService.create(alert);
    }

    @PutMapping("/{id}/resolve")
    public SupplierRiskAlert resolve(@PathVariable Long id) {
        return alertService.markResolved(id);
    }
}
