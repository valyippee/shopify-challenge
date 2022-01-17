package usecase.shipment.command;

import usecase.exceptions.InvalidInputException;
import usecase.shipment.ShipmentDTO;

public interface ShipmentCreationBoundary {

    /**
     * Creates a {@link entity.Shipment Shipment} instance.
     * @param shipmentDTO contains information needed to do so.
     */
    void createShipment(ShipmentDTO shipmentDTO) throws InvalidInputException;
}
