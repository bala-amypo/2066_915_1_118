package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import java.util.Optional;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    @Autowired
    private SupplierProfileRepository repo;

    @Override
    public SupplierProfile createSupplier(SupplierProfile supplier) {
        return repo.save(supplier);
    }

    @Override
    public Optional<SupplierProfile> getSupplierById(Long id) {
        return repo.findById(id);
    }
}
