@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {
    @Autowired private DeliveryRecordRepository deliveryRepository;

    @Override
    public List<DeliveryRecord> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public List<DeliveryRecord> getDeliveriesByPo(Long poId) {
        return deliveryRepository.findByPoId(poId);
    }
}