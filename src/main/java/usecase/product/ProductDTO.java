package usecase.product;

import lombok.Getter;

public class ProductDTO {
    @Getter
    private final long id;

    @Getter
    private final String name;

    @Getter
    private final String description;

    @Getter
    private final int minimumRequired;

    @Getter
    private final int inventoryAtHand;

    public ProductDTO(long id, String name, String description, int minimumRequired, int inventoryAtHand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minimumRequired = minimumRequired;
        this.inventoryAtHand = inventoryAtHand;
    }
}