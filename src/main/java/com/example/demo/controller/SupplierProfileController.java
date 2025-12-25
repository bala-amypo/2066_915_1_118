package com.example.demo.controller;

import com.example.demo.model.SupplierProfile;
import com.example.demo.service.SupplierProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierProfileController {

    private final SupplierProfileService supplierService;

    public SupplierProfileController(SupplierProfileService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public SupplierProfile create(@RequestBody SupplierProfile supplier) {
        return supplierService.createSupplier(supplier);
    }

    @GetMapping("/{id}")
    public SupplierProfile getById(@PathVariable Long id) {
        return supplierService.getSupplierById(id);
    }

    @GetMapping("/active")
    public List<SupplierProfile> getActive() {
        return supplierService.getActiveSuppliers();
    }

    @PutMapping("/{id}/deactivate")
    public SupplierProfile deactivate(@PathVariable Long id) {
        return supplierService.deactivateSupplier(id);
    }
}
