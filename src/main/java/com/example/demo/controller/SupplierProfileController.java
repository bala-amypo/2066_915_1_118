package com.example.demo.controller;

import com.example.demo.entity.SupplierProfile;
import com.example.demo.service.SupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suppliers")
public class SupplierProfileController {

    @Autowired
    private SupplierProfileService supplierService;

    @PostMapping("/create")
    public SupplierProfile createSupplier(@RequestBody SupplierProfile supplier) {
        return supplierService.createSupplier(supplier);
    }

    @GetMapping("/{id}")
    public SupplierProfile getSupplierById(@PathVariable Long id) {
        return supplierService.getSupplierById(id);
    }
}
