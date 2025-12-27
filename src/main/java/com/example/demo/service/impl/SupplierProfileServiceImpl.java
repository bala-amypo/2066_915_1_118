// SupplierProfileServiceImpl.java
package com.example.demo.service.impl;
import com.example.demo.exception.*;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {
    private final SupplierProfileRepository repository;
    public SupplierProfileServiceImpl(SupplierProfileRepository repository) { this.repository = repository; }

    public SupplierProfile createSupplier(SupplierProfile s) { return repository.save(s); }
    public List<SupplierProfile> getAllSuppliers() { return repository.findAll(); }
    public Optional<SupplierProfile> getBySupplierCode(String code) { return repository.findBySupplierCode(code); }
    public SupplierProfile getSupplierById(Long id) { 
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supplier not found")); 
    }
    public SupplierProfile updateSupplierStatus(Long id, boolean active) {
        SupplierProfile s = getSupplierById(id);
        s.setActive(active);
        return repository.save(s);
    }
}

// PurchaseOrderServiceImpl.java
package com.example.demo.service.impl;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    private final PurchaseOrderRecordRepository repository;
    private final SupplierProfileRepository supplierRepository;

    public PurchaseOrderServiceImpl(PurchaseOrderRecordRepository repository, SupplierProfileRepository supplierRepository) {
        this.repository = repository;
        this.supplierRepository = supplierRepository;
    }

    public PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord po) {
        SupplierProfile s = supplierRepository.findById(po.getSupplierId())
            .orElseThrow(() -> new BadRequestException("Invalid supplierId"));
        if (!s.getActive()) throw new BadRequestException("must be active");
        return repository.save(po);
    }
    public List<PurchaseOrderRecord> getPOsBySupplier(Long id) { return repository.findBySupplierId(id); }
    public Optional<PurchaseOrderRecord> getPOById(Long id) { return repository.findById(id); }
    public List<PurchaseOrderRecord> getAllPurchaseOrders() { return repository.findAll(); }
}

// DeliveryRecordServiceImpl.java
package com.example.demo.service.impl;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {
    private final DeliveryRecordRepository repository;
    private final PurchaseOrderRecordRepository poRepository;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository repository, PurchaseOrderRecordRepository poRepository) {
        this.repository = repository;
        this.poRepository = poRepository;
    }

    public DeliveryRecord recordDelivery(DeliveryRecord d) {
        poRepository.findById(d.getPoId()).orElseThrow(() -> new BadRequestException("Invalid PO id"));
        if (d.getDeliveredQuantity() < 0) throw new BadRequestException("Delivered quantity must be >=");
        return repository.save(d);
    }
    public List<DeliveryRecord> getDeliveriesByPO(Long id) { return repository.findByPoId(id); }
    public List<DeliveryRecord> getAllDeliveries() { return repository.findAll(); }
}

// SupplierRiskAlertServiceImpl.java
package com.example.demo.service.impl;
import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {
    private final SupplierRiskAlertRepository repository;
    public SupplierRiskAlertServiceImpl(SupplierRiskAlertRepository repository) { this.repository = repository; }

    public SupplierRiskAlert createAlert(SupplierRiskAlert a) {
        if (a.getResolved() == null) a.setResolved(false);
        return repository.save(a);
    }
    public List<SupplierRiskAlert> getAlertsBySupplier(Long id) { return repository.findBySupplierId(id); }
    public List<SupplierRiskAlert> getAllAlerts() { return repository.findAll(); }
    public SupplierRiskAlert resolveAlert(Long id) {
        SupplierRiskAlert a = repository.findById(id).orElseThrow();
        a.setResolved(true);
        return repository.save(a);
    }
}