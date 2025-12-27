@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {
    // ... repository ...

    @Override
    public SupplierProfile getBySupplierCode(String code) {
        return repository.findBySupplierCode(code)
            .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
    }
}