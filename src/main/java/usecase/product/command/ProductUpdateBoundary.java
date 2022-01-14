package usecase.product.command;

import usecase.exceptions.DoesNotExistException;
import usecase.exceptions.InvalidInputException;
import usecase.product.ProductWithIdDTO;

/**
 * An interface containing update methods of CRUD
 * that manipulates {@link entity.Product Product} instances.
 */
public interface ProductUpdateBoundary {

    /**
     * Updates a {@link entity.Product Product} instance.
     * @param productWithIdDTO contains new information to be updated.
     */
    void updateProduct(ProductWithIdDTO productWithIdDTO) throws DoesNotExistException, InvalidInputException;
}
