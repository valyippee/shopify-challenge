package usecase.shipment;

import usecase.dataaccess.ShipmentDataAccess;

/**
 * A use case class that contains command methods (create, update, and delete)
 * that manipulates {@link entity.Shipment Shipment} instances.
 */
public class ShipmentCommand {
    private final ShipmentDataAccess shipmentDataAccess;

    public ShipmentCommand(ShipmentDataAccess shipmentDataAccess) {
        this.shipmentDataAccess = shipmentDataAccess;
    }




}
