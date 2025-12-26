package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrderRecord;
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
    public PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord po) {
        return repo.save(po);
    }

    @Override
    public List<PurchaseOrderRecord> getOrdersBySupplier(Long supplierId) {
        return repo.findBySupplierId(supplierId);
    }
}
