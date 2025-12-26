package com.example.demo.service;

import com.example.demo.entity.PurchaseOrder;
import java.util.List;

public interface PurchaseOrderService {
    List<PurchaseOrder> getAll();
    List<PurchaseOrder> getOrdersBySupplier(Long supplierId);
    PurchaseOrder save(PurchaseOrder po);
}
