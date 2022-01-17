package usecase.product;

import lombok.Getter;

/**
 * A DTO class that contains information about a {@link entity.Product} instance.
 * To be passed down by the controllers when a request to create {@link entity.Product} instances
 * is called from the outer layers.
 */
public class ProductDTO {

    @Getter
    private final String name;

    @Getter
    private final String description;

    @Getter
    private final int minimumRequired;

    @Getter
    private final int inventoryAtHand;

    public ProductDTO(String name, String description, int minimumRequired, int inventoryAtHand) {
        this.name = name;
        this.description = description;
        this.minimumRequired = minimumRequired;
        this.inventoryAtHand = inventoryAtHand;
    }
}
