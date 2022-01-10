package repository;

import usecase.dataaccess.ShipmentDataAccess;

public class ShipmentRepository implements ShipmentDataAccess {
    private final IdGenerator idGenerator;

    public ShipmentRepository(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
