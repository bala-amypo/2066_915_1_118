public interface SupplierRiskAlertRepository
        extends JpaRepository<SupplierRiskAlert, Long> {
    List<SupplierRiskAlert> findBySupplierId(Long supplierId);
    List<SupplierRiskAlert> findByResolvedFalse();
}
