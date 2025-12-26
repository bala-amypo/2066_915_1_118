package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.DelayScoreService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    @Autowired
    private PurchaseOrderRecordRepository poRepo;

    @Autowired
    private SupplierProfileRepository supplierRepo;

    @Override
    public Map<Long, Integer> calculateDelayScores() {
        Map<Long, Integer> scores = new HashMap<>();
        List<PurchaseOrderRecord> orders = poRepo.findAll();

        for (PurchaseOrderRecord po : orders) {
            SupplierProfile supplier = supplierRepo.findById(po.getSupplierId()).orElse(null);
            if (supplier != null && supplier.getActive()) {
                LocalDate promised = po.getPromisedDeliveryDate();
                LocalDate today = LocalDate.now();
                int delayDays = (today.isAfter(promised)) ? (int) (today.toEpochDay() - promised.toEpochDay()) : 0;
                scores.put(po.getSupplierId(), delayDays);
            }
        }
        return scores;
    }
}
