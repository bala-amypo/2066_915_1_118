package com.example.demo.repository;
import com.example.demo.model.DelayScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface DelayScoreRecordRepository extends JpaRepository<DelayScoreRecord, Long> {
    List<DelayScoreRecord> findBySupplierId(Long supplierId);
    Optional<DelayScoreRecord> findByPoId(Long poId);
}