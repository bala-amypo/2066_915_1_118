package com.example.demo.service.impl;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.DelayScoreRepository;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.DelayScoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    private final DelayScoreRepository delayScoreRepository;
    private final PurchaseOrderRepository purchaseOrderRepository;

    public DelayScoreServiceImpl(DelayScoreRepository delayScoreRepository,
                                 PurchaseOrderRepository purchaseOrderRepository) {
        this.delayScoreRepository = delayScoreRepository;
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    @Override
    public DelayScoreRecord computeDelayScore(Long poId) {
        PurchaseOrderRecord po =
                purchaseOrderRepository.findById(poId).orElse(null);

        if (po == null) return null;

        long delayDays = ChronoUnit.DAYS.between(
                po.getPromisedDeliveryDate(), LocalDate.now());

        if (delayDays < 0) delayDays = 0;

        String severity =
                delayDays == 0 ? "ON_TIME" :
                delayDays <= 3 ? "LOW" :
                delayDays <= 7 ? "MEDIUM" : "HIGH";

        double score = Math.max(0, 100 - (delayDays * 5));

        DelayScoreRecord record = new DelayScoreRecord();
        record.setPoId(poId);
        record.setSupplierId(po.getSupplierId());
        record.setDelayDays((int) delayDays);
        record.setDelaySeverity(severity);
        record.setScore(score);
        record.setComputedAt(LocalDateTime.now());

        return delayScoreRepository.save(record);
    }

    @Override
    public DelayScoreRecord getScoreById(Long id) {
        return delayScoreRepository.findById(id).orElse(null);
    }

    @Override
    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return delayScoreRepository.findBySupplierId(supplierId);
    }

    @Override
    public List<DelayScoreRecord> getAllScores() {
        return delayScoreRepository.findAll();
    }
}
