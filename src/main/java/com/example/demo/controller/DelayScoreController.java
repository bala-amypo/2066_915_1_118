package com.example.demo.controller;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.service.DelayScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delay-scores")
public class DelayScoreController {

    @Autowired
    private DelayScoreService service;

    @GetMapping
    public List<DelayScoreRecord> getAllDelayScores() {
        return service.getAllDelayScores();
    }

    @GetMapping("/{id}")
    public DelayScoreRecord getDelayScoreById(@PathVariable Long id) {
        return service.getDelayScoreById(id);
    }

    @PostMapping
    public DelayScoreRecord createDelayScore(@RequestBody DelayScoreRecord record) {
        return service.createDelayScore(record);
    }

    @PutMapping("/{id}")
    public DelayScoreRecord updateDelayScore(@PathVariable Long id, @RequestBody DelayScoreRecord record) {
        return service.updateDelayScore(id, record);
    }

    @DeleteMapping("/{id}")
    public void deleteDelayScore(@PathVariable Long id) {
        service.deleteDelayScore(id);
    }
}
