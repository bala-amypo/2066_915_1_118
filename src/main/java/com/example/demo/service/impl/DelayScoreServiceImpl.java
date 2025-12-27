package com.example.demo.service.impl;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.repository.DelayScoreRepository;
import com.example.demo.service.DelayScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DelayScoreServiceImpl implements DelayScoreService {
    @Autowired private DelayScoreRepository repository;

    @Override
    public List<DelayScoreRecord> getAllScores() {
        return repository.findAll();
    }

    @Override
    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return repository.findAll().stream()
                .filter(s -> s.getSupplierId().equals(supplierId))
                .collect(Collectors.toList());
    }

    @Override
    public DelayScoreRecord calculateAndSaveScore(Long poId) {
        // Logic for score calculation goes here
        return null; 
    }
}