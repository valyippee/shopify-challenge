package usecase.product.command;

/**
 * An interface containing delete methods of CRUD
 * that manipulates {@link entity.Product} instances.
 */
public interface ProductDeletionBoundary {

    /**
     * Deletes a {@link entity.Product} instance.
     * @param productId the id of the product to be deleted.
     */
    void deleteProduct(long productId);
}
