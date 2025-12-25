package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRecordRepository poRepo;

    public PurchaseOrderServiceImpl(PurchaseOrderRecordRepository poRepo) {
        this.poRepo = poRepo;
    }

    @Override
    public PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord po) {
        if (po.getPoNumber() == null || po.getPoNumber().isBlank()) {
            throw new BadRequestException("PO number is required");
        }

        poRepo.findByPoNumber(po.getPoNumber())
                .ifPresent(p -> {
                    throw new BadRequestException("Purchase order already exists");
                });

        return poRepo.save(po);
    }

    @Override
    public PurchaseOrderRecord getById(Long id) {
        return poRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase order not found"));
    }

    @Override
    public List<PurchaseOrderRecord> getOrdersBySupplier(Long supplierId) {
        return poRepo.findBySupplierId(supplierId);
    }
}
