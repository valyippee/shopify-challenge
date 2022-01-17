package usecase.shipment.command;

import usecase.dataaccess.ShipmentDataAccess;
import usecase.exceptions.InvalidInputException;
import usecase.shipment.ShipmentDTO;

import java.util.Map;

/**
 * A use case class that contains command methods (create, update, and delete)
 * that manipulates {@link entity.Shipment Shipment} instances.
 */
public class ShipmentCommandService implements ShipmentCreationBoundary {
    private final ShipmentDataAccess shipmentDataAccess;

    public ShipmentCommandService(ShipmentDataAccess shipmentDataAccess) {
        this.shipmentDataAccess = shipmentDataAccess;
    }

    @Override
    public void createShipment(ShipmentDTO shipmentDTO) throws InvalidInputException {
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
