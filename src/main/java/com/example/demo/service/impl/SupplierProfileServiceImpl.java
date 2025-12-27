package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class SupplierProfileServiceImpl implements SupplierProfileService {

    @Autowired
    private SupplierProfileRepository repository;

    @Override
    public SupplierProfile createSupplier(SupplierProfile profile) {
        return repository.saveAndFlush(profile);
    }

    @Override
    public SupplierProfile getSupplierById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
    }

    @Override
    public SupplierProfile updateSupplierStatus(Long id, boolean status) {
        SupplierProfile s = getSupplierById(id);
        s.setActive(status);
        return repository.saveAndFlush(s);
    }

    @Override
    public SupplierProfile toggleStatus(Long id) {
        SupplierProfile s = getSupplierById(id);
        s.setActive(!s.getActive());
        return repository.saveAndFlush(s);
    }

    @Override
    public SupplierProfile getBySupplierCode(String code) {
        return repository.findBySupplierCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
    }

    @Override
    public List<SupplierProfile> getAllSuppliers() {
        return repository.findAll();
    }
}