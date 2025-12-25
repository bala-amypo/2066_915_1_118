package com.example.demo.service;

import com.example.demo.entity.SupplierProfile;
import java.util.List;

public interface SupplierProfileService {
    SupplierProfile saveSupplierProfile(SupplierProfile supplierProfile);
    List<SupplierProfile> getAllSuppliers();
    SupplierProfile getSupplierById(Long id);
    void deleteSupplier(Long id);
}
