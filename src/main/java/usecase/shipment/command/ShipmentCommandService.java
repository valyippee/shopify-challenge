package usecase.shipment.command;

import usecase.dataaccess.ShipmentDataAccess;

/**
 * A use case class that contains command methods (create, update, and delete)
 * that manipulates {@link entity.Shipment Shipment} instances.
 */
public class ShipmentCommandService implements ShipmentCreationBoundary, ShipmentUpdateBoundary, ShipmentDeletionBoundary {
    private final ShipmentDataAccess shipmentDataAccess;

    public ShipmentCommandService(ShipmentDataAccess shipmentDataAccess) {
        this.shipmentDataAccess = shipmentDataAccess;
    }




}
