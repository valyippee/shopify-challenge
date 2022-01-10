package repository;

import usecase.dataaccess.ShipmentDataAccess;

import java.util.Map;

public class ShipmentRepository implements ShipmentDataAccess {
    private final IdGenerator idGenerator;

    public ShipmentRepository(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public void createShipment(String name, String description, Map<Long, Integer> productAmount, long warehouseId) {

    }
}
