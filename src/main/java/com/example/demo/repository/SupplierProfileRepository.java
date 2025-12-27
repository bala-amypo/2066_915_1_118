package com.example.demo.repository;

import com.example.demo.entity.SupplierProfile;

import java.util.List;
import java.util.Optional;

public interface SupplierProfileRepository {

    SupplierProfile save(SupplierProfile supplier);

    Optional<SupplierProfile> findById(Long id);

    Optional<SupplierProfile> findBySupplierCode(String supplierCode);

    List<SupplierProfile> findAll();
}
