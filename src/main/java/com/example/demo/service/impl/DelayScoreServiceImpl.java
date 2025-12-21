package com.example.demo.service.impl;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.repository.DelayScoreRecordRepository;
import com.example.demo.service.DelayScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    @Autowired
    private DelayScoreRecordRepository repository;

    @Override
    public List<DelayScoreRecord> getAllDelayScores() {
        return repository.findAll();
    }

    @Override
    public DelayScoreRecord getDelayScoreById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public DelayScoreRecord createDelayScore(DelayScoreRecord record) {
        return repository.save(record);
    }

    @Override
    public DelayScoreRecord updateDelayScore(Long id, DelayScoreRecord record) {
        if (repository.existsById(id)) {
            record.setId(id);
            return repository.save(record);
        }
        return null;
    }

    @Override
    public void deleteDelayScore(Long id) {
        repository.deleteById(id);
    }
}
