package usecase.shipment.command;

import usecase.exceptions.DoesNotExistException;
import usecase.exceptions.InvalidInputException;
import usecase.shipment.ShipmentDTO;

/**
 * An interface containing create methods of CRUD
 * that manipulates {@link entity.Shipment} instances.
 */
public interface ShipmentCreationBoundary {

    /**
     * Creates a {@link entity.Shipment} instance.
     * @param shipmentDTO contains information needed to do so.
     * @throws InvalidInputException when the inputs given are invalid.
     * @throws DoesNotExistException when the products included in this shipment does not exist in the database.
     */
    void createShipment(ShipmentDTO shipmentDTO) throws InvalidInputException, DoesNotExistException;
}
