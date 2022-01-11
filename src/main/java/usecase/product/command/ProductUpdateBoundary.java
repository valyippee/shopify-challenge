package usecase.product.command;

import usecase.product.query.ProductInputDTO;

/**
 * An interface containing update methods of CRUD
 * that manipulates {@link entity.Product Product} instances.
 */
public interface ProductUpdateBoundary {

    /**
     * Updates a {@link entity.Product Product} instance.
     * @param productInputDTO contains new information to be updated.
     */
    void updateProduct(ProductInputDTO productInputDTO);
}
