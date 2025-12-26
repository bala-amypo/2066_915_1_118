package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.PurchaseOrderRecord;
import java.util.List;

public interface PurchaseOrderRecordRepository extends JpaRepository<PurchaseOrderRecord, Long> {
    List<PurchaseOrderRecord> findBySupplierId(Long supplierId);
}
