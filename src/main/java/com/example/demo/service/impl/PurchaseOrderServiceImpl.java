package com.example.demo.service.impl;

import com.example.demo.model.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRecordRepository; // Updated Import
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRecordRepository poRepository; // Using the 'Record' version

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder po) {
        return poRepository.saveAndFlush(po);
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return poRepository.findAll();
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        return poRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase Order not found"));
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return poRepository.findBySupplierId(supplierId);
    }
}