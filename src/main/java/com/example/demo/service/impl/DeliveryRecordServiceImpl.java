package com.example.demo.service.impl;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    private final DeliveryRecordRepository deliveryRepository;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public DeliveryRecord createDeliveryRecord(DeliveryRecord record) {
        return deliveryRepository.save(record);
    }

    @Override
    public List<DeliveryRecord> getDeliveriesByPO(Long purchaseOrderId) {
        return deliveryRepository.findByPurchaseOrderId(purchaseOrderId);
    }

    @Override
    public Optional<DeliveryRecord> getDeliveryById(Long id) {
        return deliveryRepository.findById(id);
    }

    @Override
    public List<DeliveryRecord> getAllDeliveries() {
        return deliveryRepository.findAll();
    }
}
