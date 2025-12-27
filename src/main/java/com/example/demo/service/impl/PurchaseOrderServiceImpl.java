package com.example.demo.service.impl;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    private final PurchaseOrderRecordRepository repository;
    private final SupplierProfileRepository supplierRepository;

    public PurchaseOrderServiceImpl(PurchaseOrderRecordRepository repository, SupplierProfileRepository supplierRepository) {
        this.repository = repository;
        this.supplierRepository = supplierRepository;
    }

    public PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord po) {
        SupplierProfile s = supplierRepository.findById(po.getSupplierId())
            .orElseThrow(() -> new BadRequestException("Invalid supplierId"));
        if (!s.getActive()) throw new BadRequestException("must be active");
        return repository.save(po);
    }
    public List<PurchaseOrderRecord> getPOsBySupplier(Long id) { return repository.findBySupplierId(id); }
    public Optional<PurchaseOrderRecord> getPOById(Long id) { return repository.findById(id); }
    public List<PurchaseOrderRecord> getAllPurchaseOrders() { return repository.findAll(); }
}