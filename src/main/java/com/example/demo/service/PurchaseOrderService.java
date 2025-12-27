package com.example.demo.service;

import com.example.demo.entity.PurchaseOrderRecord;

import java.util.List;
import java.util.Optional;

public interface PurchaseOrderService {

    PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord po);

    Optional<PurchaseOrderRecord> getPOById(Long id);

    List<PurchaseOrderRecord> getPOsBySupplier(Long supplierId);

    List<PurchaseOrderRecord> getAllPurchaseOrders();
}
