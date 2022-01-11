package usecase.product;

import lombok.Getter;

public class ProductInputDTO {

    @Getter
    private final String name;

    @Getter
    private final String description;

    @Getter
    private final int minimumRequired;

    @Getter
    private final int inventoryAtHand;

    public ProductInputDTO(String name, String description, int minimumRequired, int inventoryAtHand) {
        this.name = name;
        this.description = description;
        this.minimumRequired = minimumRequired;
        this.inventoryAtHand = inventoryAtHand;
    }
}
