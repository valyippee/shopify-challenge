package usecase.shipment;

import lombok.Getter;

import java.util.Map;

/**
 * A DTO class that contains information about a {@link entity.Shipment} instance.
 * To be passed down by the controllers when a request to create {@link entity.Shipment} instances
 * is called from the outer layers.
 */
public class ShipmentDTO {

    @Getter
    private final String name;

    @Getter
    private final String description;

    @Getter
    private final Map<Long, Integer> productAmount;

    @Getter
    private final String destination;

    public ShipmentDTO(String name, String description, Map<Long, Integer> productAmount, String destination) {
        this.name = name;
        this.description = description;
        this.productAmount = productAmount;
        this.destination = destination;
    }
}
