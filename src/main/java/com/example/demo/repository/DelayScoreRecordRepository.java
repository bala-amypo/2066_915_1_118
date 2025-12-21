package com.example.demo.repository;

import com.example.demo.model.DelayScore;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DelayScoreRecordRepository extends JpaRepository<DelayScore, Long> {
    List<DelayScore> findByPoId(Long poId);
}
