package com.example.demo.repository;

import com.example.demo.model.DelayScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelayScoreRepository extends JpaRepository<DelayScoreRecord, Long> {
    // This provides the saveAndFlush() method needed by your Service
}