package usecase.product.command;

import usecase.exceptions.InvalidInputException;
import usecase.product.ProductDTO;

/**
 * An interface containing create methods of CRUD
 * that manipulates {@link entity.Product Product} instances.
 */
public interface ProductCreationBoundary {

    /**
     * Creates a {@link entity.Product Product} instance.
     * @param productDTO contains information needed to do so.
     */
    void createProduct(ProductDTO productDTO) throws InvalidInputException;
}
