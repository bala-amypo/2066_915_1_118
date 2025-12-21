package com.example.demo.service.impl;

import com.example.demo.model.DelayScore;
import com.example.demo.repository.DelayScoreRecordRepository;
import com.example.demo.service.DelayScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    @Autowired
    private DelayScoreRecordRepository repository;

    @Override
    public DelayScore createDelayScore(DelayScore delayScore) {
        return repository.save(delayScore);
    }

    @Override
    public List<DelayScore> getAllDelayScores() {
        return repository.findAll();
    }

    @Override
    public DelayScore getDelayScoreById(Long id) {
        Optional<DelayScore> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public DelayScore updateDelayScore(Long id, DelayScore delayScore) {
        Optional<DelayScore> optional = repository.findById(id);
        if (optional.isPresent()) {
            DelayScore existing = optional.get();
            existing.setScore(delayScore.getScore());
            existing.setDescription(delayScore.getDescription());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteDelayScore(Long id) {
        repository.deleteById(id);
    }
}
