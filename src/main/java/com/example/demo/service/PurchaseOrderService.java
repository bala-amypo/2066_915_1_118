package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;

import java.util.List;

public interface PurchaseOrderService {

    PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord po);

    PurchaseOrderRecord getPOById(Long id);

    List<PurchaseOrderRecord> getPOsBySupplier(Long supplierId);

    List<PurchaseOrderRecord> getAllPurchaseOrders();
}
