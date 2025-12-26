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
    private PurchaseOrderRecordRepository repo;

    @Override
    public List<PurchaseOrderRecord> getDeliveriesForPO(Long poId) {
        return repo.findByPurchaseOrderId(poId);
    }

    @Override
    public PurchaseOrderRecord save(PurchaseOrderRecord record) {
        return repo.save(record);
    }
}
