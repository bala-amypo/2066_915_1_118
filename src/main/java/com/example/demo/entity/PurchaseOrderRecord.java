package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId;

    private String poNumber;

    private Integer quantity;

    private LocalDate issuedDate;

    private LocalDate promisedDeliveryDate;

    // Constructors
    public PurchaseOrderRecord() {}

    public PurchaseOrderRecord(Long id, Long supplierId, String poNumber, Integer quantity,
                               LocalDate issuedDate, LocalDate promisedDeliveryDate) {
        this.id = id;
        this.supplierId = supplierId;
        this.poNumber = poNumber;
        this.quantity = quantity;
        this.issuedDate = issuedDate;
        this.promisedDeliveryDate = promisedDeliveryDate;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }

    public String getPoNumber() { return poNumber; }
    public void setPoNumber(String poNumber) { this.poNumber = poNumber; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public LocalDate getIssuedDate() { return issuedDate; }
    public void setIssuedDate(LocalDate issuedDate) { this.issuedDate = issuedDate; }

    public LocalDate getPromisedDeliveryDate() { return promisedDeliveryDate; }
    public void setPromisedDeliveryDate(LocalDate promisedDeliveryDate) { this.promisedDeliveryDate = promisedDeliveryDate; }

    // Equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseOrderRecord)) return false;
        PurchaseOrderRecord that = (PurchaseOrderRecord) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
