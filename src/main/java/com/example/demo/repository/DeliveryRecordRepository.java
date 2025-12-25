public interface DeliveryRecordRepository
        extends JpaRepository<DeliveryRecord, Long> {
    List<DeliveryRecord> findByPoId(Long poId);
}
