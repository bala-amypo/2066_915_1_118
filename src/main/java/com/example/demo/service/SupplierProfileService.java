package com.example.demo.service;

import com.example.demo.model.SupplierProfile;
import java.util.List;
import java.util.Optional;

public interface SupplierProfileService {
    SupplierProfile createSupplier(SupplierProfile profile);
    SupplierProfile getSupplierById(Long id);
    // Note: The implementation must match these exact names
    Optional<SupplierProfile> getBySupplierCode(String code); 
    SupplierProfile updateSupplierStatus(Long id, boolean status);
    SupplierProfile toggleStatus(Long id);
    List<SupplierProfile> getAllSuppliers();
}