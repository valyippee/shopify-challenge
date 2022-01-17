package usecase.shipment;

import entity.Shipment;

/**
 * A utility class that maps a {@link entity.Shipment} instance to
 * a {@link ShipmentDTO ShipmentDTO} instance.
 */
public final class ShipmentMapper {

    /**
     * A private constructor to prevent instantiation.
     */
    private ShipmentMapper() {
    }

    /**
     * Maps a {@link entity.Shipment} instance to a {@link ShipmentDTOWithIdAndStatus} instance.
     * @param shipment a {@link entity.Shipment} instance to be
     *                mapped to a {@link ShipmentDTOWithIdAndStatus} instance.
     * @return the corresponding {@link ShipmentDTOWithIdAndStatus} instance.
     */
    public static ShipmentDTOWithIdAndStatus shipmentToShipmentDTOWithDetails(Shipment shipment) {
        return new ShipmentDTOWithIdAndStatus(shipment.getId(), shipment.getName(),
                shipment.getDescription(), shipment.getProductAmount(),
                shipment.getDestination(), shipment.getShipmentStatus().toString());
    }
}
