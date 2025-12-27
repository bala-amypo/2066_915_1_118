package com.example.demo.repository;

import com.example.demo.entity.SupplierRiskAlert;

import java.util.List;
import java.util.Optional;

public interface SupplierRiskAlertRepository {

    SupplierRiskAlert save(SupplierRiskAlert alert);

    Optional<SupplierRiskAlert> findById(Long id);

    List<SupplierRiskAlert> findBySupplierId(Long supplierId);

    List<SupplierRiskAlert> findAll();
}
