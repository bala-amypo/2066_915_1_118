package com.example.demo.service;

import com.example.demo.model.SupplierProfile;
import java.util.List;

public interface SupplierProfileService {
    SupplierProfile create(SupplierProfile supplier);
    SupplierProfile getById(Long id);
    List<SupplierProfile> getAll();
    List<SupplierProfile> getActiveSuppliers();
    SupplierProfile deactivateSupplier(Long id);
}
