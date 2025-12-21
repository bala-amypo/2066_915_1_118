package com.example.demo.repository;

import com.example.demo.model.DeliveryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRecordRepository extends JpaRepository<DeliveryRecord, Long> {
}
