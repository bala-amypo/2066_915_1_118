package com.example.demo.repository;

import com.example.demo.model.DelayScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DelayScoreRecordRepository extends JpaRepository<DelayScore, Long> {
}
