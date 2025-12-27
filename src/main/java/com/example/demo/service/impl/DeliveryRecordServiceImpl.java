package com.example.demo.service.impl;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {
    private final DeliveryRecordRepository repository;
    private final PurchaseOrderRecordRepository poRepository;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository repository, PurchaseOrderRecordRepository poRepository) {
        this.repository = repository;
        this.poRepository = poRepository;
    }

    public DeliveryRecord recordDelivery(DeliveryRecord d) {
        poRepository.findById(d.getPoId()).orElseThrow(() -> new BadRequestException("Invalid PO id"));
        if (d.getDeliveredQuantity() < 0) throw new BadRequestException("Delivered quantity must be >=");
        return repository.save(d);
    }
    public List<DeliveryRecord> getDeliveriesByPO(Long id) { return repository.findByPoId(id); }
    public List<DeliveryRecord> getAllDeliveries() { return repository.findAll(); }
}