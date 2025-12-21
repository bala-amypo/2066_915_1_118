package com.example.demo.controller;

import com.example.demo.service.DelayScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delay")
@RequiredArgsConstructor
public class DelayScoreController {

    private final DelayScoreService delayScoreService;

    @PostMapping("/compute")
    public ResponseEntity<String> computeDelay() {
        delayScoreService.calculateDelayScore();
        return ResponseEntity.ok("Delay scores computed successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllScores() {
        return ResponseEntity.ok(delayScoreService.getAllScores());
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<?> getScoresBySupplier(@PathVariable Long supplierId) {
        return ResponseEntity.ok(delayScoreService.getScoresBySupplier(supplierId));
    }
}
