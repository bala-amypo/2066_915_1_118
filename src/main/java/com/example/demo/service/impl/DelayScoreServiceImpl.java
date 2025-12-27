@Service
public class DelayScoreServiceImpl implements DelayScoreService {
    @Autowired private DelayScoreRepository delayScoreRepository;

    @Override
    public List<DelayScoreRecord> getAllScores() {
        return delayScoreRepository.findAll();
    }
    
    // rename your current calculate method to match interface
    @Override
    public DelayScoreRecord calculateAndSaveScore(Long poId) {
        // ... existing logic ...
    }
}