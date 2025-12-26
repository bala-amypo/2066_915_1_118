package com.example.demo.service;

import com.example.demo.entity.SupplierProfile;

public interface SupplierProfileService {
    SupplierProfile createSupplier(SupplierProfile supplier);
    SupplierProfile getSupplierById(Long id);
}
