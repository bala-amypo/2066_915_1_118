package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class PurchaseOrderRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String poNumber;
    private Long supplierId;
    private Integer quantity;
    private LocalDate promisedDeliveryDate;
}