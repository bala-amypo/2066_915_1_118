package com.example.demo.controller;

import com.example.demo.model.PurchaseOrder;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping
    public PurchaseOrder createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        return purchaseOrderService.createPurchaseOrder(purchaseOrder);
    }

    @GetMapping
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderService.getAllPurchaseOrders();
    }

    @GetMapping("/{id}")
    public PurchaseOrder getPurchaseOrderById(@PathVariable Long id) {
        return purchaseOrderService.getPurchaseOrderById(id);
    }

    @PutMapping("/{id}")
    public PurchaseOrder updatePurchaseOrder(@PathVariable Long id, @RequestBody PurchaseOrder purchaseOrder) {
        return purchaseOrderService.updatePurchaseOrder(id, purchaseOrder);
    }

    @DeleteMapping("/{id}")
    public void deletePurchaseOrder(@PathVariable Long id) {
        purchaseOrderService.deletePurchaseOrder(id);
    }
}
