package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseOrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId;
    private LocalDate promisedDeliveryDate;

    public PurchaseOrderRecord() {}

    public PurchaseOrderRecord(Long supplierId, LocalDate promisedDeliveryDate) {
        this.supplierId = supplierId;
        this.promisedDeliveryDate = promisedDeliveryDate;
    }

    public Long getId() { return id; }
    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }
    public LocalDate getPromisedDeliveryDate() { return promisedDeliveryDate; }
    public void setPromisedDeliveryDate(LocalDate promisedDeliveryDate) { this.promisedDeliveryDate = promisedDeliveryDate; }
}
