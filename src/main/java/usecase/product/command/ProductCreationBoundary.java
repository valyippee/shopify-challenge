package usecase.product.command;

import usecase.exceptions.InvalidInputException;
import usecase.product.ProductDTO;

/**
 * An interface containing create methods of CRUD
 * that manipulates {@link entity.Product} instances.
 */
public interface ProductCreationBoundary {

    /**
     * Creates a {@link entity.Product} instance.
     * @param productDTO contains information needed to do so.
     * @throws InvalidInputException when the inputs given are invalid.
     */
    void createProduct(ProductDTO productDTO) throws InvalidInputException;
}
