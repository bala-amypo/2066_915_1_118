package com.example.demo.service;

import com.example.demo.model.SupplierProfile;
import java.util.List;

public interface SupplierProfileService {

    List<SupplierProfile> getAllSuppliers();

    SupplierProfile updateSupplierStatus(Long id, boolean active);

    // ✅ THIS METHOD CAUSED THE ERROR
    SupplierProfile getBySupplierCode(String supplierCode);
}
