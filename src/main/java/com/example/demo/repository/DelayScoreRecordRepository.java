public interface DelayScoreRecordRepository
        extends JpaRepository<DelayScoreRecord, Long> {
    Optional<DelayScoreRecord> findByPoId(Long poId);
    List<DelayScoreRecord> findBySupplierId(Long supplierId);
}
