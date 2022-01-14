package usecase.product;

import lombok.Getter;

public class ProductWithIdDTO extends ProductDTO {

    @Getter
    private final long id;

    public ProductWithIdDTO(long id, String name, String description, int minimumRequired, int inventoryAtHand) {
        super(name, description, minimumRequired, inventoryAtHand);
        this.id = id;
    }
}
