package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DelayScoreRecord;
import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.DelayScoreRecordRepository;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    private final DelayScoreRecordRepository delayRepo;
    private final PurchaseOrderRecordRepository poRepo;
    private final SupplierRiskAlertService riskAlertService;

    public DelayScoreServiceImpl(
            DelayScoreRecordRepository delayRepo,
            PurchaseOrderRecordRepository poRepo,
            SupplierRiskAlertService riskAlertService) {
        this.delayRepo = delayRepo;
        this.poRepo = poRepo;
        this.riskAlertService = riskAlertService;
    }

    @Override
    public DelayScoreRecord computeDelayScore(Long poId) {

        delayRepo.findByPoId(poId)
                .ifPresent(d -> {
                    throw new BadRequestException("Delay score already computed");
                });

        PurchaseOrderRecord po = poRepo.findById(poId)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase order not found"));

        if (po.getPromisedDeliveryDate() == null) {
            throw new BadRequestException("Promised delivery date missing");
        }

        long delayDays = ChronoUnit.DAYS.between(
                po.getPromisedDeliveryDate(),
                LocalDate.now()
        );

        if (delayDays <= 0) {
            delayDays = 0;
        }

        String severity;
        double score;

        if (delayDays <= 2) {
            severity = "LOW";
            score = 10.0;
        } else if (delayDays <= 7) {
            severity = "MEDIUM";
            score = 30.0;
        } else {
            severity = "HIGH";
            score = 60.0;
        }

        DelayScoreRecord record = new DelayScoreRecord();
        record.setPoId(poId);
        record.setSupplierId(po.getSupplierId());
        record.setDelayDays((int) delayDays);
        record.setDelaySeverity(severity);
        record.setScore(score);

        DelayScoreRecord saved = delayRepo.save(record);

        if ("HIGH".equals(severity)) {
            riskAlertService.raiseRiskAlert(
                    po.getSupplierId(),
                    "HIGH",
                    "Repeated delivery delays detected"
            );
        }

        return saved;
    }

    @Override
    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return delayRepo.findBySupplierId(supplierId);
    }
}
