package usecase.shipment.query;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

public class ShipmentOutputDTO {

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

    @Getter
    private final Map<String, LocalDateTime> statuses;

    public ShipmentOutputDTO(long id, String name, String description,
                             Map<Long, Integer> productAmount, long warehouseId,
                             String destination, Map<String, LocalDateTime> statuses) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productAmount = productAmount;
        this.warehouseId = warehouseId;
        this.destination = destination;
        this.statuses = statuses;
    }
}
