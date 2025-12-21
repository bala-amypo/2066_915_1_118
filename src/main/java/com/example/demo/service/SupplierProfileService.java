package com.example.demo.service;

import com.example.demo.model.SupplierProfile;

import java.util.List;

public interface SupplierProfileService {
    List<SupplierProfile> getAllSuppliers();
    SupplierProfile getSupplierById(Long id);
    SupplierProfile createSupplier(SupplierProfile supplier);
    SupplierProfile updateSupplier(Long id, SupplierProfile supplier);
    void deleteSupplier(Long id);
}
