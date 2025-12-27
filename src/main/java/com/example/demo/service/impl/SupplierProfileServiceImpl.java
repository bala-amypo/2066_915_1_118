package com.example.demo.service.impl;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SupplierProfileServiceImpl implements SupplierProfileService {
    @Autowired private SupplierProfileRepository repository;

    @Override
    public SupplierProfile createSupplier(SupplierProfile profile) {
        return repository.saveAndFlush(profile);
    }

    @Override
    public Optional<SupplierProfile> getBySupplierCode(String code) {
        return repository.findBySupplierCode(code);
    }

    @Override
    public List<SupplierProfile> getAllSuppliers() {
        return repository.findAll();
    }

    @Override
    public SupplierProfile updateSupplierStatus(Long id, boolean status) {
        SupplierProfile s = repository.findById(id).orElseThrow();
        s.setActive(status);
        return repository.saveAndFlush(s);
    }
}