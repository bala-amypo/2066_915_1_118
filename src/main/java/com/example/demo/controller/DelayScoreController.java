package com.example.demo.controller;

import com.example.demo.model.DelayScore;
import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.service.DelayScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delay")
public class DelayScoreController {

    private final DelayScoreService delayScoreService;

    public DelayScoreController(DelayScoreService delayScoreService) {
        this.delayScoreService = delayScoreService;
    }

    // Calculate delay for a purchase order
    @PostMapping("/calculate")
    public ResponseEntity<DelayScore> calculateDelay(@RequestBody PurchaseOrderRecord po) {
        DelayScore score = delayScoreService.calculateDelay(po);
        return ResponseEntity.ok(score);
    }

    // Get all delay scores for a supplier
    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<DelayScore>> getScoresBySupplier(@PathVariable Long supplierId) {
        List<DelayScore> scores = delayScoreService.getScoresBySupplier(supplierId);
        return ResponseEntity.ok(scores);
    }
}
