package com.example.demo.controller;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryRecordController {

    private final DeliveryRecordService service;

    public DeliveryRecordController(DeliveryRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeliveryRecord> saveRecord(@RequestBody DeliveryRecord record) {
        return ResponseEntity.ok(service.saveRecord(record));
    }

    @GetMapping
    public ResponseEntity<List<DeliveryRecord>> getAllRecords() {
        return ResponseEntity.ok(service.getAllRecords());
    }
}
