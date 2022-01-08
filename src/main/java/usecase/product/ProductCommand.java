package usecase.product;

import usecase.dataaccess.ProductDataAccess;

/**
 * A use case class that contains command methods (create, update, and delete)
 * that manipulates {@link entity.Product Product} instances.
 */
public class ProductCommand implements ProductCreationBoundary, ProductUpdateBoundary, ProductDeletionBoundary {

    private final ProductDataAccess productDataAccess;

    public ProductCommand(ProductDataAccess productDataAccess) {
        this.productDataAccess = productDataAccess;
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        productDataAccess.createProduct(productDTO.getName(), productDTO.getDescription(),
                productDTO.getInventoryAtHand(), productDTO.getMinimumRequired());
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        productDataAccess.updateProductName(productDTO.getId(), productDTO.getName());
        productDataAccess.updateProductDescription(productDTO.getId(), productDTO.getDescription());
        productDataAccess.updateProductInventoryAtHand(productDTO.getId(), productDTO.getInventoryAtHand());
        productDataAccess.updateProductMinimumInventory(productDTO.getId(), productDTO.getMinimumRequired());
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
