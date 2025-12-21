package com.example.demo.controller;

import com.example.demo.model.SupplierProfile;
import com.example.demo.service.SupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierProfileController {

    @Autowired
    private SupplierProfileService service;

    @GetMapping
    public List<SupplierProfile> getAllSuppliers() {
        return service.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public SupplierProfile getSupplierById(@PathVariable Long id) {
        return service.getSupplierById(id);
    }

    @PostMapping
    public SupplierProfile createSupplier(@RequestBody SupplierProfile supplier) {
        return service.createSupplier(supplier);
    }

    @PutMapping("/{id}")
    public SupplierProfile updateSupplier(@PathVariable Long id, @RequestBody SupplierProfile supplier) {
        return service.updateSupplier(id, supplier);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        service.deleteSupplier(id);
    }
}
