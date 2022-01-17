package usecase.shipment;

import lombok.Getter;

import java.util.Map;

/**
 * A DTO class that contains information about a {@link entity.Shipment} instance.
 * A subclass of {@link usecase.shipment.ShipmentDTO} that contains an extra id and status attribute.
 * Two main usage:
 * To be passed to the controllers to abstract away details of {@link entity.Shipment}
 * from the outer layers.
 * To be passed down by the controllers to update existing {@link entity.Shipment} instances.
 */
public class ShipmentDTOWithIdAndStatus extends ShipmentDTO {

    @Getter
    private final long id;

    @Getter
    private final String status;

    public ShipmentDTOWithIdAndStatus(long id, String name, String description,
                                      Map<Long, Integer> productAmount,
                                      String destination, String status) {
        super(name, description, productAmount, destination);
        this.id = id;
        this.status = status;
    }
}
