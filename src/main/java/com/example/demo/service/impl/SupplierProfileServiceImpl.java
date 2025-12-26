package com.example.demo.service.impl;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    @Autowired
    private SupplierProfileRepository repo;

    @Override
    public List<SupplierProfile> getActiveSuppliers() {
        return repo.findByActive(true);
    }

    @Override
    public SupplierProfile deactivateSupplier(Long id) {
        SupplierProfile s = repo.findById(id).orElse(null);
        if (s == null) return null;
        s.setActive(false);
        return repo.save(s);
    }
}
