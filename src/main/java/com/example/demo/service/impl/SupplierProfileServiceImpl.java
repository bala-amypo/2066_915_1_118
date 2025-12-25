package com.example.demo.service.impl;

import com.example.demo.entity.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    @Autowired
    private SupplierProfileRepository repository;

    @Override
    public SupplierProfile saveSupplierProfile(SupplierProfile supplierProfile) {
        return repository.save(supplierProfile);
    }

    @Override
    public List<SupplierProfile> getAllSuppliers() {
        return repository.findAll();
    }

    @Override
    public SupplierProfile getSupplierById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteSupplier(Long id) {
        repository.deleteById(id);
    }
}
