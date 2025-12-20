package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DelayScoreRecord;
import com.example.demo.model.DeliveryRecord;
import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.DelayScoreRecordRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.DelayScoreService;
import com.example.demo.service.SupplierRiskAlertService;
import com.example.demo.model.SupplierRiskAlert;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class DelayScoreServiceImpl implements DelayScoreService {

    private final DelayScoreRecordRepository delayScoreRepo;
    private final PurchaseOrderRecordRepository poRepo;
    private final DeliveryRecordRepository deliveryRepo;
    private final SupplierProfileRepository supplierRepo;
    private final SupplierRiskAlertService riskAlertService;

    public DelayScoreServiceImpl(DelayScoreRecordRepository delayScoreRepo,
                                 PurchaseOrderRecordRepository poRepo,
                                 DeliveryRecordRepository deliveryRepo,
                                 SupplierProfileRepository supplierRepo,
                                 SupplierRiskAlertService riskAlertService) {
        this.delayScoreRepo = delayScoreRepo;
        this.poRepo = poRepo;
        this.deliveryRepo = deliveryRepo;
        this.supplierRepo = supplierRepo;
        this.riskAlertService = riskAlertService;
    }

    @Override
    public DelayScoreRecord computeDelayScore(Long poId) {

        PurchaseOrderRecord po = poRepo.findById(poId)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase order not found"));

        SupplierProfile supplier = supplierRepo.findById(po.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));

        if (!Boolean.TRUE.equals(supplier.getActive())) {
            throw new BadRequestException("Inactive supplier");
        }

        List<DeliveryRecord> deliveries = deliveryRepo.findByPoId(poId);
        if (deliveries.isEmpty()) {
            throw new BadRequestException("No deliveries");
        }

        DeliveryRecord delivery = deliveries.get(0);
        long delayDays = ChronoUnit.DAYS.between(
                po.getPromisedDeliveryDate(),
                delivery.getActualDeliveryDate()
        );

        int days = (int) Math.max(0, delayDays);
        String severity;

        if (days == 0) severity = "ON_TIME";
        else if (days <= 3) severity = "MINOR";
        else if (days <= 7) severity = "MODERATE";
        else severity = "SEVERE";

        double score = Math.max(0, 100 - (days * 5));

        DelayScoreRecord record = new DelayScoreRecord(
                supplier.getId(), poId, days, severity, score
        );

        DelayScoreRecord saved = delayScoreRepo.save(record);

        if ("SEVERE".equals(severity)) {
            riskAlertService.createAlert(
                    new SupplierRiskAlert(supplier.getId(), "HIGH", "Severe delivery delay")
            );
        }

        return saved;
    }

    @Override
    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return delayScoreRepo.findBySupplierId(supplierId);
    }

    @Override
    public List<DelayScoreRecord> getAllScores() {
        return delayScoreRepo.findAll();
    }
}
