package com.example.demo.service;

import com.example.demo.model.PurchaseOrder;

import java.util.List;

public interface PurchaseOrderService {

    PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder);

    List<PurchaseOrder> getAllPurchaseOrders();

    PurchaseOrder getPurchaseOrderById(Long id);

    PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder purchaseOrder);

    void deletePurchaseOrder(Long id);
}
