package com.example.demo.service.impl;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {
    @Autowired private DeliveryRecordRepository repository;

    @Override
    public List<DeliveryRecord> getAllDeliveries() {
        return repository.findAll();
    }

    @Override
    public List<DeliveryRecord> getDeliveriesByPO(Long poId) {
        return repository.findByPoId(poId);
    }
}