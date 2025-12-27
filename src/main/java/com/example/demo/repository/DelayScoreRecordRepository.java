package com.example.demo.repository;

import com.example.demo.model.DelayScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelayScoreRecordRepository extends JpaRepository<DelayScoreRecord, Long> {
}