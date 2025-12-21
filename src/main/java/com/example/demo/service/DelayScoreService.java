package com.example.demo.service;

import com.example.demo.model.DelayScoreRecord;

import java.util.List;

public interface DelayScoreService {
    List<DelayScoreRecord> getAllDelayScores();
    DelayScoreRecord getDelayScoreById(Long id);
    DelayScoreRecord createDelayScore(DelayScoreRecord record);
    DelayScoreRecord updateDelayScore(Long id, DelayScoreRecord record);
    void deleteDelayScore(Long id);
}
