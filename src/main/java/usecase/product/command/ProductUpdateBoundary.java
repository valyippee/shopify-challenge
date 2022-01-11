package usecase.product.command;

import usecase.product.query.ProductOutputDTO;

/**
 * An interface containing update methods of CRUD
 * that manipulates {@link entity.Product Product} instances.
 */
public interface ProductUpdateBoundary {

    /**
     * Updates a {@link entity.Product Product} instance.
     * @param productOutputDTO contains new information to be updated.
     */
    void updateProduct(ProductOutputDTO productOutputDTO);

    /**
     * Updates a {@link entity.Product Product} instance with a new name.
     * @param productId id of the product
     * @param name name to be updated
     */
    void updateName(long productId, String name);

    /**
     * Updates a {@link entity.Product Product} instance with a new description.
     * @param productId id of the product
     * @param description description to be updated
     */
    void updateDescription(long productId, String description);

    /**
     * Updates a {@link entity.Product Product} instance with a new minimum
     * level of required inventory.
     * @param productId id of the product
     * @param minRequired minimum required inventory to be updated
     */
    void updateMinimumRequired(long productId, int minRequired);

    /**
     * Updates a {@link entity.Product Product} instance with a new level of inventory.
     * @param productId id of the product
     * @param inventoryAtHand current level of inventory to be updated
     */
    void updateInventoryAtHand(long productId, int inventoryAtHand);
}
