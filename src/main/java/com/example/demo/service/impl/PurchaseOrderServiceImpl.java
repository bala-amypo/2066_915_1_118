package com.example.demo.service.impl;

import com.example.demo.model.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRecordRepository repository;

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
        return repository.save(purchaseOrder);
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return repository.findAll();
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        Optional<PurchaseOrder> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder purchaseOrder) {
        Optional<PurchaseOrder> optional = repository.findById(id);
        if (optional.isPresent()) {
            PurchaseOrder existing = optional.get();
            existing.setOrderNumber(purchaseOrder.getOrderNumber());
            existing.setAmount(purchaseOrder.getAmount());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void deletePurchaseOrder(Long id) {
        repository.deleteById(id);
    }
}
