package com.example.demo.service.impl;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    private final SupplierProfileRepository supplierProfileRepository;

    public SupplierProfileServiceImpl(SupplierProfileRepository supplierProfileRepository) {
        this.supplierProfileRepository = supplierProfileRepository;
    }

    @Override
    public SupplierProfile createSupplier(SupplierProfile supplierProfile) {
        return supplierProfileRepository.save(supplierProfile);
    }

    @Override
    public SupplierProfile updateSupplier(Long id, SupplierProfile supplierProfile) {
        SupplierProfile existing = supplierProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        existing.setSupplierName(supplierProfile.getSupplierName());
        existing.setEmail(supplierProfile.getEmail());
        existing.setPhone(supplierProfile.getPhone());
        existing.setRiskLevel(supplierProfile.getRiskLevel());

        return supplierProfileRepository.save(existing);
    }

    @Override
    public List<SupplierProfile> getAllSuppliers() {
        return supplierProfileRepository.findAll();
    }

    @Override
    public Optional<SupplierProfile> getSupplierById(Long id) {
        return supplierProfileRepository.findById(id);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierProfileRepository.deleteById(id);
    }
}
