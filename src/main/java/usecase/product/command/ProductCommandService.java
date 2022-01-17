package usecase.product.command;

import usecase.dataaccess.ProductDataAccess;
import usecase.exceptions.DoesNotExistException;
import usecase.exceptions.InvalidInputException;
import usecase.product.ProductDTO;
import usecase.product.ProductDTOWithId;

/**
 * A use case class that contains command methods (create, update, and delete)
 * that manipulates {@link entity.Product Product} instances.
 */
public class ProductCommandService implements ProductCreationBoundary, ProductUpdateBoundary, ProductDeletionBoundary {

    private final ProductDataAccess productDataAccess;

    public ProductCommandService(ProductDataAccess productDataAccess) {
        this.productDataAccess = productDataAccess;
    }

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
