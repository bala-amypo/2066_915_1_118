package com.example.demo.service.impl;

import com.example.demo.model.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository; // Ensure this import matches
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository poRepository; // This symbol will now be found

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder po) {
        // Use saveAndFlush for test visibility
        return poRepository.saveAndFlush(po);
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return poRepository.findAll();
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        return poRepository.findById(id).orElseThrow(() -> new RuntimeException("PO not found"));
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return poRepository.findBySupplierId(supplierId);
    }
}