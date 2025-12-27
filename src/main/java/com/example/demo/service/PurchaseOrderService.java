package com.example.demo.service;

import com.example.demo.model.PurchaseOrder;
import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrder createPurchaseOrder(PurchaseOrder po);
    List<PurchaseOrder> getAllPurchaseOrders();
    PurchaseOrder getPurchaseOrderById(Long id);
    List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId);
}