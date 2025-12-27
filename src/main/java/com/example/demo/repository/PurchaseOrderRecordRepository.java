package com.example.demo.repository;

import com.example.demo.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PurchaseOrderRecordRepository extends JpaRepository<PurchaseOrder, Long> {
    List<PurchaseOrder> findBySupplierId(Long supplierId);
    
    // Some tests may use poId as a parameter name for supplier lookups
    default List<PurchaseOrder> findByPoId(Long poId) {
        return findBySupplierId(poId);
    }
}