package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository repo;

    @Override
    public List<PurchaseOrder> getAll() {
        return repo.findAll();
    }

    @Override
    public List<PurchaseOrder> getOrdersBySupplier(Long supplierId) {
        return repo.findBySupplierId(supplierId);
    }

    @Override
    public PurchaseOrder save(PurchaseOrder po) {
        return repo.save(po);
    }
}
