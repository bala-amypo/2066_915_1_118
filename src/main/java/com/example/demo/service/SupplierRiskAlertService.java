package com.example.demo.service;

import com.example.demo.model.SupplierRiskAlert;
import java.util.List;

public interface SupplierRiskAlertService {

    SupplierRiskAlert raiseRiskAlert(Long supplierId, String level, String message);

    List<SupplierRiskAlert> getOpenAlerts();

    SupplierRiskAlert resolveAlert(Long alertId);
}
