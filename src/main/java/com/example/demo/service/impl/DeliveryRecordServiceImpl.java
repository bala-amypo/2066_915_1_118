package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    private final DeliveryRecordRepository deliveryRepo;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository deliveryRepo) {
        this.deliveryRepo = deliveryRepo;
    }

    @Override
    public DeliveryRecord recordDelivery(DeliveryRecord delivery) {
        if (delivery.getPoId() == null) {
            throw new BadRequestException("PO ID is required");
        }
        return deliveryRepo.save(delivery);
    }

    @Override
    public List<DeliveryRecord> getDeliveriesForPO(Long poId) {
        return deliveryRepo.findByPoId(poId);
    }
}
