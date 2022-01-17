package usecase.shipment.command;

import entity.Product;
import usecase.dataaccess.ProductDataAccess;
import usecase.dataaccess.ShipmentDataAccess;
import usecase.exceptions.DoesNotExistException;
import usecase.exceptions.InvalidInputException;
import usecase.shipment.ShipmentDTO;

import java.util.Map;

/**
 * A use case class that contains command methods (currently only 'create')
 * that manipulates {@link entity.Shipment Shipment} instances.
 */
public class ShipmentCommandService implements ShipmentCreationBoundary {
    private final ShipmentDataAccess shipmentDataAccess;
    private final ProductDataAccess productDataAccess;

    public ShipmentCommandService(ShipmentDataAccess shipmentDataAccess, ProductDataAccess productDataAccess) {
        this.shipmentDataAccess = shipmentDataAccess;
        this.productDataAccess = productDataAccess;
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
        // validate name of shipment
        if (shipmentDTO.getName().equals("")) {
            throw new InvalidInputException("Name of shipment cannot be empty");
        }

        // validate product amounts
        Map<Long, Integer> productAmount = shipmentDTO.getProductAmount();
        for (Long productId : productAmount.keySet()) {
            if (productAmount.get(productId) <= 0) {
                throw new InvalidInputException("Amount of product in shipment cannot be non-positive");
            }
            try {
                Product product = productDataAccess.getProductById(productId);
                if (product.getInventoryAtHand() < productAmount.get(productId)) {
                    throw new InvalidInputException("There is insufficient inventory to fulfill this shipment.");
                }
            } catch (DoesNotExistException e) {
                throw new DoesNotExistException("One of the products attempted to be " +
                        "included in this shipment does not exist.");
            }
        }

        // update each product's current inventory
        for (Long productId : productAmount.keySet()) {
            Integer productCurrentInventory = productDataAccess.getProductById(productId).getInventoryAtHand();
            productDataAccess.updateProductInventoryAtHand(productId, productCurrentInventory - productAmount.get(productId));
        }

        // create shipment
        shipmentDataAccess.createShipment(shipmentDTO.getName(), shipmentDTO.getDescription(), shipmentDTO.getProductAmount(), shipmentDTO.getDestination());
    }
}
