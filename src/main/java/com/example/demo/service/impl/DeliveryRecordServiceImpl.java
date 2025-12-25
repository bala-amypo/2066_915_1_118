package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryRecordServiceImpl {

    private final DeliveryRecordRepository deliveryRepo;
    private final PurchaseOrderRecordRepository poRepo;

    public DeliveryRecordServiceImpl(
            DeliveryRecordRepository deliveryRepo,
            PurchaseOrderRecordRepository poRepo) {
        this.deliveryRepo = deliveryRepo;
        this.poRepo = poRepo;
    }

    public DeliveryRecord recordDelivery(DeliveryRecord d) {
        poRepo.findById(d.getPoId())
                .orElseThrow(() -> new BadRequestException("Invalid PO id"));

        if (d.getDeliveredQuantity() < 0) {
            throw new BadRequestException("Delivered quantity must be non-negative");
        }

        return deliveryRepo.save(d);
    }

    public List<DeliveryRecord> getDeliveriesByPO(Long poId) {
        return deliveryRepo.findByPoId(poId);
    }

    public List<DeliveryRecord> getAllDeliveries() {
        return deliveryRepo.findAll();
    }
}
