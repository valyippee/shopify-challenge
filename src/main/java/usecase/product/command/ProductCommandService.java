package usecase.product.command;

import usecase.dataaccess.ProductDataAccess;
import usecase.exceptions.DoesNotExistException;
import usecase.exceptions.InvalidInputException;
import usecase.product.ProductDTO;
import usecase.product.ProductDTOWithId;

/**
 * A use case class that contains command methods (create, update, and delete)
 * that manipulates {@link entity.Product} instances.
 */
public class ProductCommandService implements ProductCreationBoundary, ProductUpdateBoundary, ProductDeletionBoundary {

    private final ProductDataAccess productDataAccess;

    public ProductCommandService(ProductDataAccess productDataAccess) {
        this.productDataAccess = productDataAccess;
    }

    /**
     * Validates and creates a new {@link entity.Product} instances.
     * @param productDTO contains information needed to do so.
     * @throws InvalidInputException when the name given is an empty string,
     *                                   or when the current inventory or minimum required inventory given are of
     *                                   negative values.
     */
    @Override
    public void createProduct(ProductDTO productDTO) throws InvalidInputException {
        if (productDTO.getName().equals("")) {
            throw new InvalidInputException("Name of product cannot be empty");
        } else if (productDTO.getInventoryAtHand() < 0 || productDTO.getMinimumRequired() < 0) {
            throw new InvalidInputException("Current inventory or minimum required inventory cannot be less than 0");
        }
        productDataAccess.createProduct(productDTO.getName(), productDTO.getDescription(),
                productDTO.getInventoryAtHand(), productDTO.getMinimumRequired());
    }

    /**
     *
     * @param productDTOWithId contains new information to be updated.
     * @throws DoesNotExistException when the id given is not associated with any existing
     *                                  {@link entity.Product} instance in the database
     * @throws InvalidInputException when the name given is an empty string,
     *                                  or when the current inventory or minimum required inventory given are of
     *                                  negative values.
     */
    @Override
    public void updateProduct(ProductDTOWithId productDTOWithId) throws DoesNotExistException, InvalidInputException {
        if (productDTOWithId.getName().equals("")) {
            throw new InvalidInputException("Name of product cannot be empty");
        } else if (productDTOWithId.getInventoryAtHand() < 0 || productDTOWithId.getMinimumRequired() < 0) {
            throw new InvalidInputException("Current inventory or minimum required inventory cannot be less than 0");
        }
        productDataAccess.updateProductName(productDTOWithId.getId(), productDTOWithId.getName());
        productDataAccess.updateProductDescription(productDTOWithId.getId(), productDTOWithId.getDescription());
        productDataAccess.updateProductInventoryAtHand(productDTOWithId.getId(), productDTOWithId.getInventoryAtHand());
        productDataAccess.updateProductMinimumInventory(productDTOWithId.getId(), productDTOWithId.getMinimumRequired());
    }

    @Override
    public void deleteProduct(long productId) {
        productDataAccess.deleteProduct(productId);
    }
}
