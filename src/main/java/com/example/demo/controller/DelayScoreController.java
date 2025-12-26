package com.example.demo.controller;

import com.example.demo.dto.DelayScoreResponse;
import com.example.demo.service.DelayScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delay")
public class DelayScoreController {

    @Autowired
    private DelayScoreService delayService;

    @GetMapping("/compute/{supplierId}")
    public DelayScoreResponse computeDelayScore(@PathVariable Long supplierId) {
        return delayService.computeDelayScore(supplierId);
    }

    @GetMapping("/scores/{supplierId}")
    public List<DelayScoreResponse> getScoresBySupplier(@PathVariable Long supplierId) {
        return delayService.getScoresBySupplier(supplierId);
    }
}
