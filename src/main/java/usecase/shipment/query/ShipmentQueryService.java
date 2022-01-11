package usecase.shipment.query;

import usecase.dataaccess.ShipmentDataAccess;

/**
 * A use case class responsible for retrieving data related to
 * {@link entity.Shipment Shipment} instances.
 */
public class ShipmentQueryService implements ShipmentRequestBoundary {
    private final ShipmentDataAccess shipmentDataAccess;

    public ShipmentQueryService(ShipmentDataAccess shipmentDataAccess) {
        this.shipmentDataAccess = shipmentDataAccess;
    }
}
