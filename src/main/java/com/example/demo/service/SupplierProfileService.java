package com.example.demo.service;

import com.example.demo.model.SupplierProfile;

public interface SupplierProfileService {
    SupplierProfile updateSupplierStatus(Long id, boolean status);
    SupplierProfile updateSupplier(SupplierProfile profile);
}
