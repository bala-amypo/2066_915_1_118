package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.PurchaseOrder;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired private PurchaseOrderRepository poRepo;
    @Autowired private SupplierProfileRepository supplierRepo;

    @Override
    public PurchaseOrder createPO(PurchaseOrder po) {
        SupplierProfile s = supplierRepo.findById(po.getSupplierId())
                .orElseThrow(() -> new BadRequestException("Invalid supplierId"));
        // Fixed: Use .getActive() from Lombok
        if (!s.getActive()) throw new BadRequestException("Supplier is inactive");
        return poRepo.saveAndFlush(po);
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return poRepo.findAll();
    }

    @Override
    public PurchaseOrder getPOById(Long id) {
        return poRepo.findById(id).orElseThrow(() -> new BadRequestException("Invalid PO id"));
    }

    @Override
    public List<PurchaseOrder> getPOsBySupplier(Long supplierId) {
        return poRepo.findBySupplierId(supplierId);
    }
}