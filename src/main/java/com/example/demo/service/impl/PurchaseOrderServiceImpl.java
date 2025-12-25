package com.example.demo.service.impl;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.PurchaseOrderService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRecordRepository purchaseOrderRecordRepository;
    private final SupplierProfileRepository supplierProfileRepository;

    public PurchaseOrderServiceImpl(
            PurchaseOrderRecordRepository purchaseOrderRecordRepository,
            SupplierProfileRepository supplierProfileRepository) {
        this.purchaseOrderRecordRepository = purchaseOrderRecordRepository;
        this.supplierProfileRepository = supplierProfileRepository;
    }

    @Override
    public PurchaseOrderRecord create(PurchaseOrderRecord record) {
        return purchaseOrderRecordRepository.save(record);
    }

    @Override
    public List<PurchaseOrderRecord> getAll() {
        return purchaseOrderRecordRepository.findAll();
    }

    @Override
    public Optional<PurchaseOrderRecord> getById(Long id) {
        return purchaseOrderRecordRepository.findById(id);
    }
}
