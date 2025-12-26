package com.example.demo.controller;

import com.example.demo.entity.PurchaseOrderRecord;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService poService;

    @PostMapping("/create")
    public PurchaseOrderRecord createPurchaseOrder(@RequestBody PurchaseOrderRecord po) {
        return poService.createPurchaseOrder(po);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<PurchaseOrderRecord> getOrdersBySupplier(@PathVariable Long supplierId) {
        return poService.getOrdersBySupplier(supplierId);
    }
}
