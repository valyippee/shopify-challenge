package usecase.dataaccess;

import entity.Product;

import java.util.List;

public interface ProductDataAccess {
    void createProduct(String name, String description);
    void createProduct(String name, String description, int minRequired, int inventoryAtHand);
    Product getProductById(long productId);
    List<Product> getProductsContainingName(String name);
    List<Product> getAllProducts();
    void updateProductName(long productId, String newName);
    void updateProductDescription(long productId, String description);
    void updateProductInventoryAtHand(long productId, int inventoryAtHand);
    void updateProductMinimumInventory(long productId, int minRequired);
    void deleteProduct(long productId);
}
