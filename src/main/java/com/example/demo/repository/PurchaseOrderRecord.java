// File: src/main/java/com/example/demo/repository/PurchaseOrderRepository.java
package com.example.demo.repository;

import com.example.demo.entity.PurchaseOrderRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrderRecord, Long> {
    List<PurchaseOrderRecord> findBySupplierId(Long supplierId);
}
