package usecase.dataaccess;

import java.util.Map;

public interface ShipmentDataAccess {
    void createShipment(String name, String description, Map<Long, Integer> productAmount, long warehouseId);

}
