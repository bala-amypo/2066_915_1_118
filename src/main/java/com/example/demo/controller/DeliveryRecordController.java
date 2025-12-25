package com.example.demo.controller;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryRecordController {

    private final DeliveryRecordService deliveryService;

    public DeliveryRecordController(DeliveryRecordService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public DeliveryRecord record(@RequestBody DeliveryRecord record) {
        return deliveryService.recordDelivery(record);
    }

    @GetMapping("/po/{poId}")
    public List<DeliveryRecord> getForPO(@PathVariable Long poId) {
        return deliveryService.getDeliveriesForPO(poId);
    }
}
