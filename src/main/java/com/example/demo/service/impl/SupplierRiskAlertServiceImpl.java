@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {
    // ... repository ...

    @Override
    public List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId) {
        // Using the count logic or findBySupplierId
        return repository.findAll().stream()
            .filter(a -> a.getSupplierId().equals(supplierId))
            .toList();
    }
}