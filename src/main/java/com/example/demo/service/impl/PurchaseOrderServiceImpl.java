package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.service.PurchaseOrderService;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRecordRepository repo;

    @Override
    public PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord order) {
        return repo.save(order);
    }

    @Override
    public List<PurchaseOrderRecord> getOrdersBySupplierId(Long supplierId) {
        return repo.findBySupplierId(supplierId);
    }
}
