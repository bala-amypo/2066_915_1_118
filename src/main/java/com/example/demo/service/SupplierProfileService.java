package com.example.demo.service;

import com.example.demo.model.SupplierProfile;
import java.util.List;

public interface SupplierProfileService {
    List<SupplierProfile> getActiveSuppliers();
    SupplierProfile deactivateSupplier(Long id);
}
