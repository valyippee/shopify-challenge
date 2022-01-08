package repository;

public class ShipmentRepository {
    private final IdGenerator idGenerator;

    public ShipmentRepository(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
