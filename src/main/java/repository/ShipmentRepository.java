package repository;

import entity.Shipment;
import usecase.dataaccess.ShipmentDataAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * An implementation of {@link usecase.dataaccess.ShipmentDataAccess}.
 *
 * Provides an in-memory database by storing {@link entity.Shipment} instances in a list.
 */
public class ShipmentRepository implements ShipmentDataAccess {

    private final IdGenerator idGenerator;
    private final List<Shipment> shipmentList;

    public ShipmentRepository(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
        this.shipmentList = new ArrayList<>();
    }

    @Override
    public void createShipment(String name, String description,
                               Map<Long, Integer> productAmount,
                               String destination) {
        shipmentList.add(new Shipment(idGenerator.getNext(), name, description,
                productAmount, destination));
    }

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentList;
    }
}
