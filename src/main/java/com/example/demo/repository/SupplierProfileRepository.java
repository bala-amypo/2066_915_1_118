package com.example.demo.repository;

import com.example.demo.model.SupplierProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SupplierProfileRepository extends JpaRepository<SupplierProfile, Long> {
    List<SupplierProfile> findByActive(Boolean active);
}
