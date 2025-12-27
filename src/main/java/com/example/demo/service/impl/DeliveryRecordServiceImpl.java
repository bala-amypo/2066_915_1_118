package com.example.demo.service.impl;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    @Autowired
    private DeliveryRecordRepository deliveryRepository;

    @Autowired
    private PurchaseOrderRepository poRepository;

    @Override
    public DeliveryRecord recordDelivery(DeliveryRecord delivery) {
        poRepository.findById(delivery.getPoId())
                .orElseThrow(() -> new RuntimeException("Invalid PO id"));
        return deliveryRepository.saveAndFlush(delivery);
    }

    @Override
    public List<DeliveryRecord> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public List<DeliveryRecord> getDeliveriesByPo(Long poId) {
        return deliveryRepository.findByPoId(poId);
    }
}