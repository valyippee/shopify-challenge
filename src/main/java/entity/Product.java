package entity;

import lombok.Getter;
import lombok.Setter;

/**
 * A product entity that represents each product in the inventory.
 */
public class Product {
    @Getter
    private final long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private int inventoryAtHand;

    @Getter @Setter
    private int minimumRequired;

    public Product(long id, String name, String description, int inventoryAtHand, int minimumRequired) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.inventoryAtHand = inventoryAtHand;
        this.minimumRequired = minimumRequired;
    }
}
