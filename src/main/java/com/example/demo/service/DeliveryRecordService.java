package com.example.demo.service;

import com.example.demo.model.DeliveryRecord;

import java.util.List;

public interface DeliveryRecordService {
    List<DeliveryRecord> getAllDeliveries();
    DeliveryRecord getDeliveryById(Long id);
    DeliveryRecord createDelivery(DeliveryRecord record);
    DeliveryRecord updateDelivery(Long id, DeliveryRecord record);
    void deleteDelivery(Long id);
}
