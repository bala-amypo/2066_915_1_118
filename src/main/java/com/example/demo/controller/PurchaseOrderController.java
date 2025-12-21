package com.example.demo.controller;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService service;

    @GetMapping
    public List<PurchaseOrderRecord> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public PurchaseOrderRecord getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @PostMapping
    public PurchaseOrderRecord createOrder(@RequestBody PurchaseOrderRecord order) {
        return service.createOrder(order);
    }

    @PutMapping("/{id}")
    public PurchaseOrderRecord updateOrder(@PathVariable Long id, @RequestBody PurchaseOrderRecord order) {
        return service.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
    }
}
