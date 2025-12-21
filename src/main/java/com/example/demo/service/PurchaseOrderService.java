package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;

import java.util.List;

public interface PurchaseOrderService {
    List<PurchaseOrderRecord> getAllOrders();
    PurchaseOrderRecord getOrderById(Long id);
    PurchaseOrderRecord createOrder(PurchaseOrderRecord order);
    PurchaseOrderRecord updateOrder(Long id, PurchaseOrderRecord order);
    void deleteOrder(Long id);
}
