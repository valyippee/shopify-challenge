package usecase.product.command;

import usecase.dataaccess.ProductDataAccess;
import usecase.exceptions.DoesNotExistException;
import usecase.exceptions.InvalidInputException;
import usecase.product.ProductDTO;
import usecase.product.ProductWithIdDTO;

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
            throw new InvalidInputException("Currently inventory or minimum required inventory cannot be less than 0");
        } else {
            productDataAccess.createProduct(productDTO.getName(), productDTO.getDescription(),
                    productDTO.getInventoryAtHand(), productDTO.getMinimumRequired());
        }
    }

    @Override
    public void updateProduct(ProductWithIdDTO productWithIdDTO) throws DoesNotExistException, InvalidInputException {
        if (productWithIdDTO.getName().equals("")) {
            throw new InvalidInputException("Name of product cannot be empty");
        } else if (productWithIdDTO.getInventoryAtHand() < 0 || productWithIdDTO.getMinimumRequired() < 0) {
            throw new InvalidInputException("Currently inventory or minimum required inventory cannot be less than 0");
        }
        productDataAccess.updateProductName(productWithIdDTO.getId(), productWithIdDTO.getName());
        productDataAccess.updateProductDescription(productWithIdDTO.getId(), productWithIdDTO.getDescription());
        productDataAccess.updateProductInventoryAtHand(productWithIdDTO.getId(), productWithIdDTO.getInventoryAtHand());
        productDataAccess.updateProductMinimumInventory(productWithIdDTO.getId(), productWithIdDTO.getMinimumRequired());
    }

    @Override
    public void deleteProduct(long productId) {
        productDataAccess.deleteProduct(productId);
    }
}
