package usecase.shipment;

import lombok.Getter;

import java.util.Map;

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
