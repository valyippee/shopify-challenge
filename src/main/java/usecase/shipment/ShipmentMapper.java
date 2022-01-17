package usecase.shipment;

import entity.Shipment;

/**
 * A utility class that maps a {@link entity.Shipment Shipment} instance to
 * a {@link ShipmentDTO ShipmentDTO} instance.
 */
public final class ShipmentMapper {

    /**
     * A private constructor to prevent instantiation.
     */
    private ShipmentMapper() {
    }

    public static ShipmentDTOWithIdAndStatus shipmentToShipmentDTOWithDetails(Shipment shipment) {
        return new ShipmentDTOWithIdAndStatus(shipment.getId(), shipment.getName(),
                shipment.getDescription(), shipment.getProductAmount(),
                shipment.getDestination(), shipment.getShipmentStatus().toString());
    }
}
