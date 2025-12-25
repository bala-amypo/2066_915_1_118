public interface SupplierProfileRepository {
    Optional<SupplierProfile> findById(Long id);
    Optional<SupplierProfile> findBySupplierCode(String code);
    List<SupplierProfile> findAll();
    SupplierProfile save(SupplierProfile s);
}
