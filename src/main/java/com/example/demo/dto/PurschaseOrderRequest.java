package com.example.demo.dto;

import java.time.LocalDate;

public class PurchaseOrderRequest {
    private Long supplierId;
    private LocalDate promisedDeliveryDate;

    public PurchaseOrderRequest() {}

    public PurchaseOrderRequest(Long supplierId, LocalDate promisedDeliveryDate) {
        this.supplierId = supplierId;
        this.promisedDeliveryDate = promisedDeliveryDate;
    }

    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }

    public LocalDate getPromisedDeliveryDate() { return promisedDeliveryDate; }
    public void setPromisedDeliveryDate(LocalDate promisedDeliveryDate) { this.promisedDeliveryDate = promisedDeliveryDate; }
}
