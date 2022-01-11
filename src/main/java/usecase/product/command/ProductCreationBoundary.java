package usecase.product.command;

/**
 * An interface containing create methods of CRUD
 * that manipulates {@link entity.Product Product} instances.
 */
public interface ProductCreationBoundary {

    /**
     * Creates a {@link entity.Product Product} instance.
     * @param productInputDTO contains information needed to do so.
     */
    void createProduct(ProductInputDTO productInputDTO);
}
