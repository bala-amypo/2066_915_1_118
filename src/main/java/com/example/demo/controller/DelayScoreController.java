package com.example.demo.controller;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.service.DelayScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delay-score")
public class DelayScoreController {

    @Autowired
    private DelayScoreService delayScoreService;

    @PostMapping("/compute/{poId}")
    public DelayScoreRecord computeDelay(@PathVariable Long poId) {
        return delayScoreService.computeDelayScore(poId);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<DelayScoreRecord> getScoresBySupplier(@PathVariable Long supplierId) {
        return delayScoreService.getScoresBySupplier(supplierId);
    }

    @GetMapping("/all")
    public List<DelayScoreRecord> getAllScores() {
        return delayScoreService.getAllScores();
    }
}
