package com.example.demo.controller;

import com.example.demo.model.SupplierProfile;
import com.example.demo.service.SupplierProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierProfileController {

    private final SupplierProfileService supplierProfileService;

    public SupplierProfileController(SupplierProfileService supplierProfileService) {
        this.supplierProfileService = supplierProfileService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierProfile> getSupplier(@PathVariable Long id) {
        SupplierProfile sp = supplierProfileService.updateSupplierStatus(id, true); // dummy fetch
        return ResponseEntity.ok(sp);
    }

    @PostMapping("/updateStatus")
    public ResponseEntity<SupplierProfile> updateStatus(@RequestParam Long id, @RequestParam boolean active) {
        SupplierProfile sp = supplierProfileService.updateSupplierStatus(id, active);
        return ResponseEntity.ok(sp);
    }
}
