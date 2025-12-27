package com.example.demo.service.impl;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.repository.DelayScoreRepository;
import com.example.demo.service.DelayScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {
    @Autowired private DelayScoreRepository repository;

    @Override
    public DelayScoreRecord computeDelayScore(Long poId) {
        // Implementation logic here
        return new DelayScoreRecord(); 
    }

    @Override
    public List<DelayScoreRecord> getAllScores() {
        return repository.findAll();
    }

    @Override
    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return repository.findAll().stream()
                .filter(s -> s.getSupplierId().equals(supplierId))
                .toList();
    }
}