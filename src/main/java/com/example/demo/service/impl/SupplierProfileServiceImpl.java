package com.example.demo.service.impl;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    @Autowired
    private SupplierProfileRepository supplierRepository;

    @Override
    @Transactional
    public SupplierProfile createSupplier(SupplierProfile profile) {
        // FIX: Must return the result of save(), not null!
        return supplierRepository.save(profile);
    }

    @Override
    public SupplierProfile getSupplierByCode(String code) {
        return supplierRepository.findBySupplierCode(code)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }
}