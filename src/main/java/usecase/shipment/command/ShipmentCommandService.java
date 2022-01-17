package usecase.shipment.command;

import usecase.dataaccess.ShipmentDataAccess;
import usecase.exceptions.DoesNotExistException;
import usecase.exceptions.InvalidInputException;
import usecase.shipment.ShipmentDTO;

/**
 * A use case class that contains command methods (create, update, and delete)
 * that manipulates {@link entity.Shipment Shipment} instances.
 */
public class ShipmentCommandService implements ShipmentCreationBoundary {
    private final ShipmentDataAccess shipmentDataAccess;

    public ShipmentCommandService(ShipmentDataAccess shipmentDataAccess) {
        this.shipmentDataAccess = shipmentDataAccess;
    }

    /**
     * Validates and creates a new {@link entity.Shipment Shipment} instance.
     * @param shipmentDTO contains information needed to do so.
     * @throws InvalidInputException when the name given is an empty string, or when the
     *                                  amount of product included in the shipment contains negative values
     *                                  or that the inventory is insufficient to fulfill this shipment.
     * @throws DoesNotExistException when the products included in this shipment does not exist in the database.
     */
    @Override
    public void createShipment(ShipmentDTO shipmentDTO) throws InvalidInputException, DoesNotExistException {
        for (Integer value : shipmentDTO.getProductAmount().values()) {
            if (value < 0) {
                throw new InvalidInputException("Amount of product in shipment cannot be negative");
            }
        }
        if (shipmentDTO.getName().equals("")) {
            throw new InvalidInputException("Name of shipment cannot be empty");
        }
        shipmentDataAccess.createShipment(shipmentDTO.getName(), shipmentDTO.getDescription(), shipmentDTO.getProductAmount(), shipmentDTO.getDestination());
    }
}
