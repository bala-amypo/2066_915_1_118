@Service
public class DelayScoreServiceImpl implements DelayScoreService {
    @Autowired private DelayScoreRepository repository;

    @Override
    public List<DelayScoreRecord> getAllScores() {
        return repository.findAll();
    }

    @Override
    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return repository.findAll().stream()
                .filter(s -> s.getSupplierId().equals(supplierId))
                .collect(java.util.stream.Collectors.toList());
    }
}