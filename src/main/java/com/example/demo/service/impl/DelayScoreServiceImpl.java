@Service
public class DelayScoreServiceImpl {

    private final DelayScoreRecordRepository scoreRepo;
    private final PurchaseOrderRecordRepository poRepo;
    private final DeliveryRecordRepository deliveryRepo;
    private final SupplierProfileRepository supplierRepo;
    private final SupplierRiskAlertServiceImpl alertService;

    public DelayScoreServiceImpl(DelayScoreRecordRepository scoreRepo,
                                 PurchaseOrderRecordRepository poRepo,
                                 DeliveryRecordRepository deliveryRepo,
                                 SupplierProfileRepository supplierRepo,
                                 SupplierRiskAlertServiceImpl alertService) {
        this.scoreRepo = scoreRepo;
        this.poRepo = poRepo;
        this.deliveryRepo = deliveryRepo;
        this.supplierRepo = supplierRepo;
        this.alertService = alertService;
    }

    public DelayScoreRecord computeDelayScore(Long poId) {
        PurchaseOrderRecord po = poRepo.findById(poId)
                .orElseThrow(() -> new BadRequestException("Invalid PO"));

        SupplierProfile supplier = supplierRepo.findById(po.getSupplierId())
                .orElseThrow(() -> new BadRequestException("Supplier not found"));

        if (!supplier.getActive())
            throw new BadRequestException("Inactive supplier");

        List<DeliveryRecord> deliveries = deliveryRepo.findByPoId(poId);
        if (deliveries.isEmpty())
            throw new BadRequestException("No deliveries");

        DeliveryRecord d = deliveries.get(0);
        int delay = Math.max(0,
                (int) ChronoUnit.DAYS.between(
                        po.getPromisedDeliveryDate(),
                        d.getActualDeliveryDate()
                ));

        DelayScoreRecord r = new DelayScoreRecord();
        r.setPoId(poId);
        r.setSupplierId(po.getSupplierId());
        r.setDelayDays(delay);

        if (delay == 0) {
            r.setDelaySeverity("ON_TIME");
            r.setScore(100.0);
        } else if (delay <= 3) {
            r.setDelaySeverity("MINOR");
            r.setScore(80.0);
        } else {
            r.setDelaySeverity("SEVERE");
            r.setScore(50.0);
        }

        return scoreRepo.save(r);
    }

    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return scoreRepo.findBySupplierId(supplierId);
    }

    public List<DelayScoreRecord> getAllScores() {
        return scoreRepo.findAll();
    }
}
