package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.service.PurchaseOrderService;
import java.util.List;

@RestController
@RequestMapping("/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService poService;

    @PostMapping
    public PurchaseOrderRecord createPurchaseOrder(@RequestBody PurchaseOrderRecord order) {
        return poService.createPurchaseOrder(order);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<PurchaseOrderRecord> getOrdersBySupplier(@PathVariable Long supplierId) {
        return poService.getOrdersBySupplierId(supplierId);
    }
}
