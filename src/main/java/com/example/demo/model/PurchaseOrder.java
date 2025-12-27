package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long supplierId;
    private String orderNumber;
    private LocalDate promisedDeliveryDate;
    private LocalDate actualDeliveryDate;
    private Double totalAmount;
    private String status;
}