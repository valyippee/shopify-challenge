package usecase.dataaccess;

import entity.Shipment;
import usecase.exceptions.DoesNotExistException;

import java.util.List;
import java.util.Map;

public interface ShipmentDataAccess {
    void createShipment(String name, String description,
                        Map<Long, Integer> productAmount,
                        long warehouseId, String destination);
    List<Shipment> getAllShipments();
    Shipment getShipmentById(long shipmentId) throws DoesNotExistException;
}
