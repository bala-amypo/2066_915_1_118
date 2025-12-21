package com.example.demo.service;

import com.example.demo.model.DeliveryRecord;
import java.util.List;
import java.util.Optional;

public interface DeliveryRecordService {
    DeliveryRecord createDeliveryRecord(DeliveryRecord record);
    List<DeliveryRecord> getDeliveriesByPO(Long purchaseOrderId);
    Optional<DeliveryRecord> getDeliveryById(Long id);
    List<DeliveryRecord> getAllDeliveries();
}
