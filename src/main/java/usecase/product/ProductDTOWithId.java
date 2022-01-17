package usecase.product;

import lombok.Getter;

public class ProductDTOWithId extends ProductDTO {

    @Getter
    private final long id;

    public ProductDTOWithId(long id, String name, String description, int minimumRequired, int inventoryAtHand) {
        super(name, description, minimumRequired, inventoryAtHand);
        this.id = id;
    }
}
