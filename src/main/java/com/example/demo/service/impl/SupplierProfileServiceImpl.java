package com.example.demo.service.impl;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {
    @Autowired private SupplierProfileRepository repository;

    @Override
    public Optional<SupplierProfile> getBySupplierCode(String code) {
        return repository.findBySupplierCode(code);
    }

    @Override
    public List<SupplierProfile> getAllSuppliers() {
        return repository.findAll();
    }
    
    // Ensure method names match exactly what is in SupplierProfileService interface
}