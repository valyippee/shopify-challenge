package usecase.product;

import entity.Product;

/**
 * A utility class that maps a {@link entity.Product Product} instance to
 * a {@link ProductDTO ProductDTO} instance.
 */
public final class ProductMapper {

    /**
     * A private constructor to prevent instantiation.
     */
    private ProductMapper() {
    }

    /**
     *
     * @param product a {@link entity.Product Product} instance to be
     *                mapped to a {@link ProductDTO ProductDTO} instance.
     * @return the corresponding {@link ProductDTO ProductDTO} instance.
     */
    public static ProductDTO ProductToProductDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(),
                product.getDescription(), product.getMinimumRequired(),
                product.getInventoryAtHand());
    }
}
