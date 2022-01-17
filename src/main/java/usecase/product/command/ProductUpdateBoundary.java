package usecase.product.command;

import usecase.exceptions.DoesNotExistException;
import usecase.exceptions.InvalidInputException;
import usecase.product.ProductDTOWithId;

/**
 * An interface containing update methods of CRUD
 * that manipulates {@link entity.Product} instances.
 */
public interface ProductUpdateBoundary {

    /**
     * Updates a {@link entity.Product} instance.
     * @param productDTOWithId contains new information to be updated.
     * @throws DoesNotExistException when the product with associated id was not found in the database.
     * @throws InvalidInputException when the inputs given are invalid.
     */
    void updateProduct(ProductDTOWithId productDTOWithId) throws DoesNotExistException, InvalidInputException;
}
