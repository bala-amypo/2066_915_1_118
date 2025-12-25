package com.example.demo.controller;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    private final PurchaseOrderService poService;

    public PurchaseOrderController(PurchaseOrderService poService) {
        this.poService = poService;
    }

    @PostMapping
    public PurchaseOrderRecord createPO(@RequestBody PurchaseOrderRecord po) {
        return poService.createPurchaseOrder(po);
    }

    @GetMapping("/{id}")
    public Optional<PurchaseOrderRecord> getPO(@PathVariable Long id) {
        return poService.getPOById(id);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<PurchaseOrderRecord> getPOsBySupplier(@PathVariable Long supplierId) {
        return poService.getPOsBySupplier(supplierId);
    }

    @GetMapping
    public List<PurchaseOrderRecord> getAllPOs() {
        return poService.getAllPurchaseOrders();
    }
}
