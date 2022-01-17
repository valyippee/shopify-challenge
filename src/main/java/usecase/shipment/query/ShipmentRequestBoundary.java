package usecase.shipment.query;

import usecase.shipment.ShipmentDTOWithIdAndStatus;

import java.util.List;

/**
 * An interface containing read methods of CRUD
 * that manipulates {@link entity.Shipment} instances.
 */
public interface ShipmentRequestBoundary {

    /**
     * @return a list of {@link entity.Shipment} instances.
     */
    List<ShipmentDTOWithIdAndStatus> getAllShipments();
}
