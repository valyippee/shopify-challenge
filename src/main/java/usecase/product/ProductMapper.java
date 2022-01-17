package usecase.product;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * A utility class that maps a {@link entity.Product} instance to
 * a {@link ProductDTOWithId} instance.
 */
public final class ProductMapper {

    /**
     * A private constructor to prevent instantiation.
     */
    private ProductMapper() {
    }

    /**
     * Maps a {@link entity.Product} instance to a {@link ProductDTOWithId} instance.
     * @param product a {@link entity.Product} instance to be
     *                mapped to a {@link ProductDTOWithId} instance.
     * @return the corresponding {@link ProductDTOWithId} instance.
     */
    public static ProductDTOWithId productToProductDTOWithId(Product product) {
        return new ProductDTOWithId(product.getId(), product.getName(),
                product.getDescription(), product.getMinimumRequired(),
                product.getInventoryAtHand());
    }

    /**
     * Maps a list of {@link entity.Product} instances to {@link ProductDTOWithId} instances.
     */
    public static List<ProductDTOWithId> productToProductDTOWithId(List<Product> products) {
        List<ProductDTOWithId> productDTOWithIdList = new ArrayList<>();
        for (Product product : products) {
            productDTOWithIdList.add(productToProductDTOWithId(product));
        }
        return productDTOWithIdList;
    }
}
