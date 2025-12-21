package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DelayScore {

    private Long purchaseOrderId;
    private Long supplierId;
    private long delayDays;

    // Optional: add severity or status
    // private String status; // ON_TIME, LATE
}
