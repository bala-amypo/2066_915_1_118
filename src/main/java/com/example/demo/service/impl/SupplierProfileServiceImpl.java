package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    private final SupplierProfileRepository supplierRepo;

    public SupplierProfileServiceImpl(SupplierProfileRepository supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    @Override
    public SupplierProfile createSupplier(SupplierProfile supplier) {
        if (supplier.getSupplierCode() == null || supplier.getSupplierCode().isBlank()) {
            throw new BadRequestException("Supplier code is required");
        }

        supplierRepo.findBySupplierCode(supplier.getSupplierCode())
                .ifPresent(s -> {
                    throw new BadRequestException("Supplier already exists");
                });

        return supplierRepo.save(supplier);
    }

    @Override
    public SupplierProfile getSupplierById(Long id) {
        return supplierRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
    }

    @Override
    public List<SupplierProfile> getActiveSuppliers() {
        return supplierRepo.findByActiveTrue();
    }

    @Override
    public SupplierProfile deactivateSupplier(Long id) {
        SupplierProfile supplier = getSupplierById(id);
        supplier.setActive(false);
        return supplierRepo.save(supplier);
    }
}
