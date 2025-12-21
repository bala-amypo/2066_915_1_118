package com.example.demo.service;

import com.example.demo.model.SupplierProfile;
import java.util.List;

public interface SupplierProfileService {

    SupplierProfile createSupplier(SupplierProfile supplierProfile);

    SupplierProfile getSupplierById(Long id);

    List<SupplierProfile> getAllSuppliers();

    SupplierProfile updateSupplierStatus(Long id, boolean active);

    SupplierProfile getBySupplierCode(String supplierCode);
}
