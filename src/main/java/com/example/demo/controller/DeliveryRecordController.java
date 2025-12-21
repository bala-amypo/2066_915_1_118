package com.example.demo.controller;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery-records")
public class DeliveryRecordController {

    @Autowired
    private DeliveryRecordService service;

    @GetMapping
    public List<DeliveryRecord> getAllDeliveries() {
        return service.getAllDeliveries();
    }

    @GetMapping("/{id}")
    public DeliveryRecord getDeliveryById(@PathVariable Long id) {
        return service.getDeliveryById(id);
    }

    @PostMapping
    public DeliveryRecord createDelivery(@RequestBody DeliveryRecord record) {
        return service.createDelivery(record);
    }

    @PutMapping("/{id}")
    public DeliveryRecord updateDelivery(@PathVariable Long id, @RequestBody DeliveryRecord record) {
        return service.updateDelivery(id, record);
    }

    @DeleteMapping("/{id}")
    public void deleteDelivery(@PathVariable Long id) {
        service.deleteDelivery(id);
    }
}
