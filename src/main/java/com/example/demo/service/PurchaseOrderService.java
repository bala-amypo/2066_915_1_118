package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;
import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord order);
    List<PurchaseOrderRecord> getOrdersBySupplierId(Long supplierId);
}
