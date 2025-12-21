package com.example.demo.service.impl;

import com.example.demo.model.DelayScore;
import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.DelayScoreRecordRepository;
import com.example.demo.service.DelayScoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    private final DelayScoreRecordRepository repository;

    public DelayScoreServiceImpl(DelayScoreRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DelayScore calculateDelay(PurchaseOrderRecord po) {
        LocalDate promised = po.getPromisedDate();
        LocalDate actual = po.getActualDeliveryDate();
        long delayDays = ChronoUnit.DAYS.between(promised, actual);

        DelayScore score = new DelayScore();
        score.setPurchaseOrderId(po.getId());
        score.setSupplierId(po.getSupplierId());
        score.setDelayDays(delayDays);
        score.setDate(LocalDate.now());

        return repository.save(score);
    }

    @Override
    public List<DelayScore> getScoresBySupplier(Long supplierId) {
        // dummy implementation, you can filter by supplierId from repository
        return Collections.emptyList();
    }
}
