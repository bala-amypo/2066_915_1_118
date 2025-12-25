package com.example.demo.controller;

import com.example.demo.entity.PurchaseOrderRecord;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService orderService;

    @GetMapping
    public ResponseEntity<List<PurchaseOrderRecord>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrderRecord> getOrderById(@PathVariable Long id) {
        PurchaseOrderRecord record = orderService.getOrderById(id);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PurchaseOrderRecord> createOrder(@RequestBody PurchaseOrderRecord request) {
        PurchaseOrderRecord created = orderService.createOrder(request);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderRecord> updateOrder(
            @PathVariable Long id,
            @RequestBody PurchaseOrderRecord request) {
        PurchaseOrderRecord updated = orderService.updateOrder(id, request);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        boolean deleted = orderService.deleteOrder(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
