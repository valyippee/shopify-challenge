package usecase.product.query;

import java.util.List;

/**
 * An interface containing read methods of CRUD
 * that manipulates {@link entity.Product Product} instances.
 */
public interface ProductRequestBoundary {

    /**
     * @return a list of {@link entity.Product Product} instances.
     */
    List<ProductInputDTO> getAllProducts();

    /**
     * Return the {@link entity.Product Product} instance with the product id.
     * @param productId id used to retrieve the produce
     * @return a product instance
     */
    ProductInputDTO getProductById(long productId);

    /**
     * Return the {@link entity.Product Product} instances with the specified name as a substring.
     * @param name name used to search for products
     * @return a list of matching products
     */
    List<ProductInputDTO> getProductsContainingName(String name);
}
