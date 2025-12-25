package com.example.demo.controller;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryRecordController {

    private final DeliveryRecordService deliveryService;

    public DeliveryRecordController(DeliveryRecordService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public List<DeliveryRecord> getAll() {
        return deliveryService.getAllRecords();
    }

    @PostMapping
    public DeliveryRecord create(@RequestBody DeliveryRecord record) {
        return deliveryService.saveRecord(record);
    }

    @GetMapping("/po/{poId}")
    public List<DeliveryRecord> getByPo(@PathVariable Long poId) {
        return deliveryService.getRecordsByPo(poId);
    }
}
