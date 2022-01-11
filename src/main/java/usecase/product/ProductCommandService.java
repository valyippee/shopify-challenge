package usecase.product;

import usecase.dataaccess.ProductDataAccess;

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
    public void createProduct(ProductInputDTO productInputDTO) {
        productDataAccess.createProduct(productInputDTO.getName(), productInputDTO.getDescription(),
                productInputDTO.getInventoryAtHand(), productInputDTO.getMinimumRequired());
    }

    @Override
    public void updateProduct(ProductOutputDTO productOutputDTO) {
        productDataAccess.updateProductName(productOutputDTO.getId(), productOutputDTO.getName());
        productDataAccess.updateProductDescription(productOutputDTO.getId(), productOutputDTO.getDescription());
        productDataAccess.updateProductInventoryAtHand(productOutputDTO.getId(), productOutputDTO.getInventoryAtHand());
        productDataAccess.updateProductMinimumInventory(productOutputDTO.getId(), productOutputDTO.getMinimumRequired());
    }

    @Override
    public void updateName(long productId, String name) {
        productDataAccess.updateProductName(productId, name);
    }

    @Override
    public void updateDescription(long productId, String description) {
        productDataAccess.updateProductDescription(productId, description);
    }

    @Override
    public void updateMinimumRequired(long productId, int minRequired) {
        productDataAccess.updateProductMinimumInventory(productId, minRequired);
    }

    @Override
    public void updateInventoryAtHand(long productId, int inventoryAtHand) {
        productDataAccess.updateProductMinimumInventory(productId, inventoryAtHand);
    }

    @Override
    public void deleteProduct(long productId) {
        productDataAccess.deleteProduct(productId);
    }
}
