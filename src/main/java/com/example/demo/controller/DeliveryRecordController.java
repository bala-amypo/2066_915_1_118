package com.example.demo.controller;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryRecordController {

    @Autowired
    private DeliveryRecordService deliveryRecordService;

    @PostMapping("/record")
    public DeliveryRecord recordDelivery(@RequestBody DeliveryRecord delivery) {
        return deliveryRecordService.recordDelivery(delivery);
    }

    @GetMapping("/po/{poId}")
    public List<DeliveryRecord> getDeliveriesByPO(@PathVariable Long poId) {
        return deliveryRecordService.getDeliveriesByPO(poId);
    }

    @GetMapping("/all")
    public List<DeliveryRecord> getAllDeliveries() {
        return deliveryRecordService.getAllDeliveries();
    }
}
