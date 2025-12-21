package com.example.demo.service.impl;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    private final SupplierProfileRepository repository;

    public SupplierProfileServiceImpl(SupplierProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupplierProfile updateSupplierStatus(Long id, boolean status) {
        Optional<SupplierProfile> opt = repository.findById(id);
        if(opt.isPresent()) {
            SupplierProfile sp = opt.get();
            sp.setActive(status);
            return repository.save(sp);
        }
        return null;
    }
}
