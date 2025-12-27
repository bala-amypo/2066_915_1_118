package com.example.demo.controller;

import com.example.demo.entity.SupplierProfile;
import com.example.demo.service.SupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierProfileController {

    @Autowired
    private SupplierProfileService supplierProfileService;

    @PostMapping("/create")
    public SupplierProfile createSupplier(@RequestBody SupplierProfile supplier) {
        return supplierProfileService.createSupplier(supplier);
    }

    @GetMapping("/{id}")
    public SupplierProfile getSupplier(@PathVariable Long id) {
        return supplierProfileService.getSupplierById(id);
    }

    @GetMapping("/all")
    public List<SupplierProfile> getAllSuppliers() {
        return supplierProfileService.getAllSuppliers();
    }

    @PutMapping("/{id}/status")
    public SupplierProfile updateStatus(@PathVariable Long id, @RequestParam Boolean active) {
        return supplierProfileService.updateSupplierStatus(id, active);
    }

    @GetMapping("/code/{code}")
    public Optional<SupplierProfile> getByCode(@PathVariable String code) {
        return supplierProfileService.getBySupplierCode(code);
    }
}
