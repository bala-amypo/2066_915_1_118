package com.example.demo.service;

import com.example.demo.model.DelayScore;
import com.example.demo.model.PurchaseOrderRecord;
import java.util.List;

public interface DelayScoreService {
    DelayScore calculateDelay(PurchaseOrderRecord po);
    List<DelayScore> getScoresBySupplier(Long supplierId);
}
