package com.example.demo.controller;

import com.example.demo.entity.SupplierProfile;
import com.example.demo.service.SupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierProfileController {

    @Autowired
    private SupplierProfileService service;

    @PostMapping
    public SupplierProfile createSupplier(@RequestBody SupplierProfile supplierProfile) {
        return service.saveSupplierProfile(supplierProfile);
    }

    @GetMapping
    public List<SupplierProfile> getAllSuppliers() {
        return service.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public SupplierProfile getSupplier(@PathVariable Long id) {
        return service.getSupplierById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        service.deleteSupplier(id);
    }
}
