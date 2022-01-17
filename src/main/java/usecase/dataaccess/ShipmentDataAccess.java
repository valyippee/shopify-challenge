package usecase.dataaccess;

import entity.Shipment;

import java.util.List;
import java.util.Map;

/**
 * Provides an interface to access {@link entity.Shipment} instances
 */
public interface ShipmentDataAccess {
    void createShipment(String name, String description,
                        Map<Long, Integer> productAmount,
                        String destination);
    List<Shipment> getAllShipments();
}
