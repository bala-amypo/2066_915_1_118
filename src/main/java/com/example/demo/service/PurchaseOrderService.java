package com.example.demo.service;

import com.example.demo.entity.PurchaseOrderRecord;

import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord po);
    List<PurchaseOrderRecord> getOrdersBySupplier(Long supplierId);
}
