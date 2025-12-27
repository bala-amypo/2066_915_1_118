package com.example.demo.service.impl;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.model.DeliveryRecord;
import com.example.demo.model.PurchaseOrder;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.DelayScoreRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.DelayScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Transactional
public class DelayScoreServiceImpl implements DelayScoreService {

    @Autowired private DelayScoreRepository delayScoreRepository;
    @Autowired private PurchaseOrderRepository poRepository; // FIX: Updated name
    @Autowired private DeliveryRecordRepository deliveryRepository;
    @Autowired private SupplierProfileRepository supplierRepository;

    @Override
    public DelayScoreRecord calculateAndSaveScore(Long poId) {
        PurchaseOrder po = poRepository.findById(poId)
                .orElseThrow(() -> new RuntimeException("PO not found"));

        SupplierProfile supplier = supplierRepository.findById(po.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        List<DeliveryRecord> deliveries = deliveryRepository.findByPoId(poId);
        if (deliveries.isEmpty()) {
            throw new RuntimeException("No deliveries found for this PO");
        }

        // Logic to get the latest delivery date
        DeliveryRecord latest = deliveries.stream()
                .max((d1, d2) -> d1.getActualDeliveryDate().compareTo(d2.getActualDeliveryDate()))
                .get();

        long daysDelayed = ChronoUnit.DAYS.between(po.getPromisedDeliveryDate(), latest.getActualDeliveryDate());
        
        DelayScoreRecord record = new DelayScoreRecord();
        record.setPoId(po.getId());
        record.setSupplierId(po.getSupplierId());
        record.setDelayDays((int) Math.max(0, daysDelayed));
        
        // Example Scoring Logic
        double score = (daysDelayed <= 0) ? 100.0 : Math.max(0, 100.0 - (daysDelayed * 5.0));
        record.setScore(score);
        record.setDelaySeverity(score < 50 ? "HIGH" : (score < 80 ? "MEDIUM" : "LOW"));

        return delayScoreRepository.saveAndFlush(record);
    }
}