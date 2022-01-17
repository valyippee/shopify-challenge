package usecase.product;

import lombok.Getter;

/**
 * A DTO class that contains information about a {@link entity.Product} instance.
 * A subclass of {@link usecase.product.ProductDTO} that contains an extra id attribute.
 * Two main usage:
 * To be passed to the controllers to abstract away details of {@link entity.Product}
 * from the outer layers.
 * To be passed down by the controllers to update existing {@link entity.Product} instances.
 */
public class ProductDTOWithId extends ProductDTO {

    @Getter
    private final long id;

    public ProductDTOWithId(long id, String name, String description, int minimumRequired, int inventoryAtHand) {
        super(name, description, minimumRequired, inventoryAtHand);
        this.id = id;
    }
}
