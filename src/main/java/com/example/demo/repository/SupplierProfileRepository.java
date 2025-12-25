package com.example.demo.service;

import com.example.demo.model.SupplierProfile;

import java.util.List;
import java.util.Optional;

public interface SupplierProfileService {

    SupplierProfile createSupplier(SupplierProfile supplierProfile);

    SupplierProfile updateSupplier(Long id, SupplierProfile supplierProfile);

    List<SupplierProfile> getAllSuppliers();

    Optional<SupplierProfile> getSupplierById(Long id);

    void deleteSupplier(Long id);
}
