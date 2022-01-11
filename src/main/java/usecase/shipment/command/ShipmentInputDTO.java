package usecase.shipment.command;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class ShipmentInputDTO {

    @Getter
    private final long id;

    @Getter
    private final String name;

    @Getter
    private final String description;

    @Getter
    private final Map<Long, Integer> productAmount;

    @Getter
    private final long warehouseId;

    @Getter
    private final String destination;

    public ShipmentInputDTO(long id, String name, String description, Map<Long, Integer> productAmount, long warehouseId, String destination) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productAmount = productAmount;
        this.warehouseId = warehouseId;
        this.destination = destination;
    }
}
