package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;
import java.util.List;

public interface PurchaseOrderService {
    List<PurchaseOrderRecord> getAll();
    PurchaseOrderRecord getById(Long id);
    List<PurchaseOrderRecord> getOrdersBySupplier(Long supplierId);
}
