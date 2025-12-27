package com.example.demo.repository;

import com.example.demo.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PurchaseOrderRecordRepository extends JpaRepository<PurchaseOrder, Long> {
    // Standard lookups often required by supply chain tests
    List<PurchaseOrder> findBySupplierId(Long supplierId);
}