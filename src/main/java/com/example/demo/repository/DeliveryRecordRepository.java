package com.example.demo.repository;

import com.example.demo.entity.DeliveryRecord;

import java.util.List;

public interface DeliveryRecordRepository {

    DeliveryRecord save(DeliveryRecord delivery);

    List<DeliveryRecord> findByPoId(Long poId);

    List<DeliveryRecord> findAll();
}
