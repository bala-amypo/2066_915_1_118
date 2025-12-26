package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.SupplierProfile;
import com.example.demo.service.SupplierProfileService;
import java.util.Optional;

@RestController
@RequestMapping("/suppliers")
public class SupplierProfileController {

    @Autowired
    private SupplierProfileService supplierService;

    @PostMapping
    public SupplierProfile createSupplier(@RequestBody SupplierProfile supplier) {
        return supplierService.createSupplier(supplier);
    }

    @GetMapping("/{id}")
    public Optional<SupplierProfile> getSupplier(@PathVariable Long id) {
        return supplierService.getSupplierById(id);
    }
}
