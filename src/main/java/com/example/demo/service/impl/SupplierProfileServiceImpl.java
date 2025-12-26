package com.example.demo.service.impl;

import com.example.demo.entity.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    @Autowired
    private SupplierProfileRepository repo;

    @Override
    public SupplierProfile createSupplier(SupplierProfile supplier) {
        return repo.save(supplier);
    }

    @Override
    public SupplierProfile getSupplierById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
