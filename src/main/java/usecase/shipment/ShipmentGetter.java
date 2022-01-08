package usecase.shipment;

import usecase.dataaccess.ShipmentDataAccess;

/**
 * A use case class responsible for retrieving data related to
 * {@link entity.Shipment Shipment} instances.
 */
public class ShipmentGetter {
    private final ShipmentDataAccess shipmentDataAccess;

    public ShipmentGetter(ShipmentDataAccess shipmentDataAccess) {
        this.shipmentDataAccess = shipmentDataAccess;
    }
}
