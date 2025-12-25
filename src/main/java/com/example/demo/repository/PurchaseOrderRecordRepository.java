public interface PurchaseOrderRecordRepository
        extends JpaRepository<PurchaseOrderRecord, Long> {
    List<PurchaseOrderRecord> findBySupplierId(Long supplierId);
    Optional<PurchaseOrderRecord> findByPoNumber(String poNumber);
}
