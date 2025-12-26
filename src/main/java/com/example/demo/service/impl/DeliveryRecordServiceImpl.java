package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    @Autowired
    private PurchaseOrderRecordRepository poRepo;

    @Override
    public List<PurchaseOrderRecord> getAll() {
        return poRepo.findAll();
    }

    @Override
    public PurchaseOrderRecord save(PurchaseOrderRecord record) {
        return poRepo.save(record);
    }
}
