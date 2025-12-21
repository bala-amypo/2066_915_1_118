package com.example.demo.service.impl;

import com.example.demo.model.DelayScore;
import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.service.DelayScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DelayScoreServiceImpl implements DelayScoreService {

    private final PurchaseOrderRecordRepository poRepository;
    private final List<DelayScore> delayScores = new ArrayList<>();

    @Override
    public void calculateDelayScore() {
        delayScores.clear(); // recalculate every time
        List<PurchaseOrderRecord> orders = poRepository.findAll();

        for (PurchaseOrderRecord po : orders) {
            long delayDays = 0;
            if (po.getActualDeliveryDate() != null && po.getPromisedDate() != null) {
                delayDays = ChronoUnit.DAYS.between(po.getPromisedDate(), po.getActualDeliveryDate());
                if (delayDays < 0) delayDays = 0; // no negative delay
            }
            DelayScore score = new DelayScore();
            score.setPurchaseOrderId(po.getId());
            score.setSupplierId(po.getSupplierId());
            score.setDelayDays(delayDays);
            delayScores.add(score);
        }
    }

    @Override
    public List<DelayScore> getAllScores() {
        return new ArrayList<>(delayScores);
    }

    @Override
    public List<DelayScore> getScoresBySupplier(Long supplierId) {
        List<DelayScore> supplierScores = new ArrayList<>();
        for (DelayScore ds : delayScores) {
            if (ds.getSupplierId().equals(supplierId)) {
                supplierScores.add(ds);
            }
        }
        return supplierScores;
    }
}
