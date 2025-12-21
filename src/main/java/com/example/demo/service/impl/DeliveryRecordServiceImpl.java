package com.example.demo.service.impl;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    @Autowired
    private DeliveryRecordRepository repository;

    @Override
    public List<DeliveryRecord> getAllDeliveries() {
        return repository.findAll();
    }

    @Override
    public DeliveryRecord getDeliveryById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public DeliveryRecord createDelivery(DeliveryRecord record) {
        return repository.save(record);
    }

    @Override
    public DeliveryRecord updateDelivery(Long id, DeliveryRecord record) {
        if (repository.existsById(id)) {
            record.setId(id);
            return repository.save(record);
        }
        return null;
    }

    @Override
    public void deleteDelivery(Long id) {
        repository.deleteById(id);
    }
}
