package usecase.product.command;

import usecase.dataaccess.ProductDataAccess;
import usecase.product.query.ProductInputDTO;

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
    public void createProduct(usecase.product.command.ProductInputDTO productInputDTO) {
        productDataAccess.createProduct(productInputDTO.getName(), productInputDTO.getDescription(),
                productInputDTO.getInventoryAtHand(), productInputDTO.getMinimumRequired());
    }

    @Override
    public void updateProduct(ProductInputDTO productInputDTO) {
        productDataAccess.updateProductName(productInputDTO.getId(), productInputDTO.getName());
        productDataAccess.updateProductDescription(productInputDTO.getId(), productInputDTO.getDescription());
        productDataAccess.updateProductInventoryAtHand(productInputDTO.getId(), productInputDTO.getInventoryAtHand());
        productDataAccess.updateProductMinimumInventory(productInputDTO.getId(), productInputDTO.getMinimumRequired());
    }

    @Override
    public void deleteProduct(long productId) {
        productDataAccess.deleteProduct(productId);
    }
}
