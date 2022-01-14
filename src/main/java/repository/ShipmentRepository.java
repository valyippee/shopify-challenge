package repository;

import entity.Shipment;
import usecase.dataaccess.ShipmentDataAccess;
import usecase.exceptions.DoesNotExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                               long warehouseId, String destination) {
        shipmentList.add(new Shipment(idGenerator.getNext(), name, description,
                productAmount, warehouseId, destination));
    }

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentList;
    }

    @Override
    public Shipment getShipmentById(long shipmentId) throws DoesNotExistException {
        for (Shipment shipment : shipmentList) {
            if (shipment.getId() == shipmentId) {
                return shipment;
            }
        }
        throw new DoesNotExistException("Shipment does not exist");
    }
}
