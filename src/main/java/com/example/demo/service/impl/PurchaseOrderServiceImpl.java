package com.example.demo.service.impl;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRecordRepository repository;

    @Override
    public List<PurchaseOrderRecord> getAllOrders() {
        return repository.findAll();
    }

    @Override
    public PurchaseOrderRecord getOrderById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public PurchaseOrderRecord createOrder(PurchaseOrderRecord order) {
        return repository.save(order);
    }

    @Override
    public PurchaseOrderRecord updateOrder(Long id, PurchaseOrderRecord order) {
        if (repository.existsById(id)) {
            order.setId(id);
            return repository.save(order);
        }
        return null;
    }

    @Override
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}
