package com.example.demo.service.impl;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    private final DeliveryRecordRepository deliveryRepository;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public DeliveryRecord recordDelivery(DeliveryRecord record) {
        return deliveryRepository.save(record);
    }

    @Override
    public List<DeliveryRecord> getByPurchaseOrderId(Long purchaseOrderId) {
        return deliveryRepository.findByPurchaseOrderId(purchaseOrderId);
    }
}
