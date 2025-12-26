package com.example.demo.service.impl;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository repo;

    public PurchaseOrderServiceImpl(PurchaseOrderRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<PurchaseOrderRecord> getAll() {
        return repo.findAll();
    }

    @Override
    public PurchaseOrderRecord getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<PurchaseOrderRecord> getOrdersBySupplier(Long supplierId) {
        return repo.findBySupplierId(supplierId);
    }
}
