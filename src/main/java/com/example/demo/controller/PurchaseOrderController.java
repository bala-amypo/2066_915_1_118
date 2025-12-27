package com.example.demo.controller;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase-order")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping("/create")
    public PurchaseOrderRecord createPO(@RequestBody PurchaseOrderRecord po) {
        return purchaseOrderService.createPurchaseOrder(po);
    }

    @GetMapping("/{id}")
    public Optional<PurchaseOrderRecord> getPOById(@PathVariable Long id) {
        return purchaseOrderService.getPOById(id);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<PurchaseOrderRecord> getPOsBySupplier(@PathVariable Long supplierId) {
        return purchaseOrderService.getPOsBySupplier(supplierId);
    }

    @GetMapping("/all")
    public List<PurchaseOrderRecord> getAllPOs() {
        return purchaseOrderService.getAllPurchaseOrders();
    }
}
