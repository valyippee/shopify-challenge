package usecase.product;

/**
 * An interface containing delete methods of CRUD
 * that manipulates {@link entity.Product Product} instances.
 */
public interface ProductDeletionBoundary {

    /**
     * Deletes a {@link entity.Product Product} instance.
     * @param productId the id of the product to be deleted.
     */
    void deleteProduct(long productId);
}
