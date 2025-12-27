package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SupplierProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String supplierCode;
    private String supplierName;
    private String email;
    private Boolean active = true;
}