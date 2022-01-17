package usecase.dataaccess;

import entity.Product;
import usecase.exceptions.DoesNotExistException;

import java.util.List;

/**
 * Provides an interface to access {@link entity.Product} instances
 */
public interface ProductDataAccess {
    void createProduct(String name, String description);
    void createProduct(String name, String description, int minRequired, int inventoryAtHand);
    Product getProductById(long productId) throws DoesNotExistException;
    List<Product> getProductsContainingName(String name);
    List<Product> getAllProducts();
    void updateProductName(long productId, String newName) throws DoesNotExistException;
    void updateProductDescription(long productId, String description) throws DoesNotExistException;
    void updateProductInventoryAtHand(long productId, int inventoryAtHand) throws DoesNotExistException;
    void updateProductMinimumInventory(long productId, int minRequired) throws DoesNotExistException;
    void deleteProduct(long productId);
}
