package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.PurchaseOrder;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired private PurchaseOrderRepository poRepo;
    @Autowired private SupplierProfileRepository supplierRepo;

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder po) {
        SupplierProfile s = supplierRepo.findById(po.getSupplierId())
                .orElseThrow(() -> new BadRequestException("Invalid supplierId"));
        if (!s.getActive()) throw new BadRequestException("Supplier is inactive");
        return poRepo.saveAndFlush(po);
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        return poRepo.findById(id).orElseThrow(() -> new BadRequestException("Invalid PO id"));
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return poRepo.findBySupplierId(supplierId);
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return poRepo.findAll();
    }
}