package com.example.demo.service.impl;

import com.example.demo.entity.DelayScoreRecord;
import com.example.demo.entity.DeliveryRecord;
import com.example.demo.entity.PurchaseOrderRecord;
import com.example.demo.entity.SupplierProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.DelayScoreRecordRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.DelayScoreService;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    @Autowired
    private DelayScoreRecordRepository delayScoreRecordRepository;

    @Autowired
    private PurchaseOrderRecordRepository poRepository;

    @Autowired
    private DeliveryRecordRepository deliveryRepository;

    @Autowired
    private SupplierProfileRepository supplierProfileRepository;

    @Autowired
    private SupplierRiskAlertService riskAlertService;

    public DelayScoreServiceImpl(DelayScoreRecordRepository delayRepo,
                                 PurchaseOrderRecordRepository poRepo,
                                 DeliveryRecordRepository deliveryRepo,
                                 SupplierProfileRepository supplierRepo,
                                 SupplierRiskAlertService riskService) {
        this.delayScoreRecordRepository = delayRepo;
        this.poRepository = poRepo;
        this.deliveryRepository = deliveryRepo;
        this.supplierProfileRepository = supplierRepo;
        this.riskAlertService = riskService;
    }

    @Override
    public DelayScoreRecord computeDelayScore(Long poId) {
        PurchaseOrderRecord po = poRepository.findById(poId)
                .orElseThrow(() -> new BadRequestException("PO not found"));

        SupplierProfile supplier = supplierProfileRepository.findById(po.getSupplierId())
                .orElseThrow(() -> new BadRequestException("Supplier not found"));

        if (!Boolean.TRUE.equals(supplier.getActive())) {
            throw new BadRequestException("Inactive supplier");
        }

        List<DeliveryRecord> deliveries = deliveryRepository.findByPoId(poId);
        if (deliveries.isEmpty()) {
            throw new BadRequestException("No deliveries for this PO");
        }

        DeliveryRecord delivery = deliveries.get(0); // Assuming 1 delivery for score
        long delayDays = ChronoUnit.DAYS.between(po.getPromisedDeliveryDate(), delivery.getActualDeliveryDate());

        DelayScoreRecord record = new DelayScoreRecord();
        record.setPoId(poId);
        record.setSupplierId(po.getSupplierId());
        record.setDelayDays((int) Math.max(delayDays, 0));

        if (delayDays <= 0) record.setDelaySeverity("ON_TIME");
        else if (delayDays <= 3) record.setDelaySeverity("MINOR");
        else if (delayDays <= 7) record.setDelaySeverity("MAJOR");
        else record.setDelaySeverity("SEVERE");

        record.setScore(100.0 - Math.min(delayDays * 10, 100.0));

        return delayScoreRecordRepository.save(record);
    }

    @Override
    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return delayScoreRecordRepository.findBySupplierId(supplierId);
    }

    @Override
    public List<DelayScoreRecord> getAllScores() {
        return delayScoreRecordRepository.findAll();
    }
}
