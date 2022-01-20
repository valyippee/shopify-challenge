package repository;

import usecase.dataaccess.ProductDataAccess;
import entity.Product;
import usecase.exceptions.DoesNotExistException;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of {@link usecase.dataaccess.ProductDataAccess}.
 *
 * Provides an in-memory database by storing {@link entity.Product} instances in a list.
 */
public class ProductRepository implements ProductDataAccess {

    private final IdGenerator idGenerator;
    private final List<Product> productList;

    public ProductRepository(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
        this.productList = new ArrayList<>();
    }

    @Override
    public void createProduct(String name, String description) {
        this.createProduct(name, description, 0, 0);
    }

    @Override
    public void createProduct(String name, String description, int inventoryAtHand, int minRequired) {
        productList.add(new Product(idGenerator.getNext(), name, description, inventoryAtHand, minRequired));
    }

    @Override
    public Product getProductById(long productId) throws DoesNotExistException {
        for (Product product : productList) {
            if (product.getId() == productId) {
                return product;
            }
        }
        throw new DoesNotExistException("Product does not exist");
    }

    @Override
    public List<Product> getProductsContainingName(String name) {
        List<Product> productsWithMatchingName = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                productsWithMatchingName.add(product);
            }
        }
        return productsWithMatchingName;
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productList;
    }

    @Override
    public void updateProductName(long productId, String newName) throws DoesNotExistException {
        Product product = this.getProductById(productId);
        product.setName(newName);
    }

    @Override
    public void updateProductDescription(long productId, String description) throws DoesNotExistException {
        Product product = this.getProductById(productId);
        product.setDescription(description);
    }

    @Override
    public void updateProductInventoryAtHand(long productId, int inventoryAtHand) throws DoesNotExistException {
        Product product = this.getProductById(productId);
        product.setInventoryAtHand(inventoryAtHand);
    }

    @Override
    public void updateProductMinimumInventory(long productId, int minRequired) throws DoesNotExistException {
        Product product = this.getProductById(productId);
        product.setMinimumRequired(minRequired);
    }

    @Override
    public void deleteProduct(long productId) {
        for (Product product : productList) {
            if (product.getId() == productId) {
                productList.remove(product);
                return;
            }
        }
    }
}
