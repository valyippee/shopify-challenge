package usecase.product.command;

import usecase.exceptions.DoesNotExistException;
import usecase.exceptions.InvalidInputException;
import usecase.product.ProductDTOWithId;

/**
 * An interface containing update methods of CRUD
 * that manipulates {@link entity.Product Product} instances.
 */
public interface ProductUpdateBoundary {

    /**
     * Updates a {@link entity.Product Product} instance.
     * @param productDTOWithId contains new information to be updated.
     */
    void updateProduct(ProductDTOWithId productDTOWithId) throws DoesNotExistException, InvalidInputException;
}
