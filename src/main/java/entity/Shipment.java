package entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class Shipment {
    @Getter
    private final long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private Map<Long, Integer> productAmount;

    @Getter @Setter
    private long warehouseId;

    @Getter @Setter
    private String destination;

    private ShipmentStatus shipmentStatus;

    public Shipment(long id, Map<Long, Integer> productAmount, long warehouseId, String destination) {
        this.id = id;
        this.productAmount = productAmount;
        this.warehouseId = warehouseId;
        this.destination = destination;
    }

    public void updateProductAmount(Long productId, Integer amount) {
        this.productAmount.put(productId, amount);
    }
}
