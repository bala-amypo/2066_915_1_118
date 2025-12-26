@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    @Autowired
    private SupplierProfileRepository repo;

    @Override
    public List<SupplierProfile> getActiveSuppliers() {
        return repo.findByActive(true);
    }

    @Override
    public SupplierProfile deactivateSupplier(Long id) {
        SupplierProfile s = repo.findById(id).orElse(null);
        if (s == null) return null;
        s.setActive(false);
        return repo.save(s);
    }

    // other methods...
}
