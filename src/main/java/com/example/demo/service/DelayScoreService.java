package com.example.demo.service;

import com.example.demo.model.DelayScore;

import java.util.List;

public interface DelayScoreService {

    DelayScore createDelayScore(DelayScore delayScore);

    List<DelayScore> getAllDelayScores();

    DelayScore getDelayScoreById(Long id);

    DelayScore updateDelayScore(Long id, DelayScore delayScore);

    void deleteDelayScore(Long id);
}
