package com.example.demo.controller;

import com.example.demo.model.DelayScore;
import com.example.demo.service.DelayScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delay-scores")
public class DelayScoreController {

    @Autowired
    private DelayScoreService delayScoreService;

    @PostMapping
    public DelayScore createDelayScore(@RequestBody DelayScore delayScore) {
        return delayScoreService.createDelayScore(delayScore);
    }

    @GetMapping
    public List<DelayScore> getAllDelayScores() {
        return delayScoreService.getAllDelayScores();
    }

    @GetMapping("/{id}")
    public DelayScore getDelayScoreById(@PathVariable Long id) {
        return delayScoreService.getDelayScoreById(id);
    }

    @PutMapping("/{id}")
    public DelayScore updateDelayScore(@PathVariable Long id, @RequestBody DelayScore delayScore) {
        return delayScoreService.updateDelayScore(id, delayScore);
    }

    @DeleteMapping("/{id}")
    public void deleteDelayScore(@PathVariable Long id) {
        delayScoreService.deleteDelayScore(id);
    }
}
