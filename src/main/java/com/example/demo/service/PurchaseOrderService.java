package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;
import java.util.List;

public interface PurchaseOrderService {

    PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord po);

    PurchaseOrderRecord getById(Long id);

    List<PurchaseOrderRecord> getOrdersBySupplier(Long supplierId);
}
