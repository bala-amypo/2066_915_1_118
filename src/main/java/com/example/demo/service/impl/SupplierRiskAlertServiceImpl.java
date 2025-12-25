@Service
public class SupplierRiskAlertServiceImpl {

    private final SupplierRiskAlertRepository repo;

    public SupplierRiskAlertServiceImpl(SupplierRiskAlertRepository repo) {
        this.repo = repo;
    }

    public SupplierRiskAlert createAlert(SupplierRiskAlert a) {
        a.setResolved(false);
        return repo.save(a);
    }

    public List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId) {
        return repo.findBySupplierId(supplierId);
    }

    public SupplierRiskAlert resolveAlert(Long id) {
        SupplierRiskAlert a = repo.findById(id)
                .orElseThrow(() -> new BadRequestException("Alert not found"));
        a.setResolved(true);
        return repo.save(a);
    }

    public List<SupplierRiskAlert> getAllAlerts() {
        return repo.findAll();
    }
}
