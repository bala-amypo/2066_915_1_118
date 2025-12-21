package com.example.demo.service.impl;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    private final SupplierProfileRepository repository;

    public SupplierProfileServiceImpl(SupplierProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupplierProfile createSupplier(SupplierProfile supplier) {
        supplier.setCreatedAt(LocalDateTime.now());
        return repository.save(supplier);
    }

    @Override
    public SupplierProfile getSupplierById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public SupplierProfile getBySupplierCode(String supplierCode) {
        return repository.findBySupplierCode(supplierCode).orElse(null);
    }

    @Override
    public List<SupplierProfile> getAllSuppliers() {
        return repository.findAll();
    }

    @Override
    public SupplierProfile updateSupplierStatus(Long id, boolean active) {
        SupplierProfile supplier = repository.findById(id).orElse(null);
        if (supplier != null) {
            supplier.setActive(active);
            return repository.save(supplier);
        }
        return null;
    }
}
