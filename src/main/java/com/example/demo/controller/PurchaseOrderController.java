package com.example.demo.controller;

import com.example.demo.dto.PurchaseOrderRequest;
import com.example.demo.dto.PurchaseOrderResponse;
import com.example.demo.service.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/purchase-orders")
@CrossOrigin(origins = "*")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseOrderResponse> createPurchaseOrder(@RequestBody PurchaseOrderRequest request) {
        return ResponseEntity.ok(purchaseOrderService.createOrder(request));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrderResponse>> getAllOrders() {
        return ResponseEntity.ok(purchaseOrderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrderResponse> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(purchaseOrderService.getOrderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderResponse> updateOrder(
            @PathVariable Long id,
            @RequestBody PurchaseOrderRequest request
    ) {
        return ResponseEntity.ok(purchaseOrderService.updateOrder(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        purchaseOrderService.deleteOrder(id);
        return ResponseEntity.ok("Purchase Order deleted successfully");
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<PurchaseOrderResponse> updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        return ResponseEntity.ok(purchaseOrderService.updateOrderStatus(id, status));
    }
}
