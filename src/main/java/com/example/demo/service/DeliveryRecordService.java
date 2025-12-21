package com.example.demo.service;

import com.example.demo.model.DeliveryRecord;
import java.util.List;

public interface DeliveryRecordService {
    DeliveryRecord recordDelivery(DeliveryRecord record);
    List<DeliveryRecord> getByPurchaseOrderId(Long purchaseOrderId);
}
