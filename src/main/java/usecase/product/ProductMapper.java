package usecase.product;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * A utility class that maps a {@link entity.Product Product} instance to
 * a {@link ProductDTOWithId ProductDTO} instance.
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
     *                mapped to a {@link ProductDTOWithId ProductDTO} instance.
     * @return the corresponding {@link ProductDTOWithId ProductDTO} instance.
     */
    public static ProductDTOWithId productToProductDTOWithId(Product product) {
        return new ProductDTOWithId(product.getId(), product.getName(),
                product.getDescription(), product.getMinimumRequired(),
                product.getInventoryAtHand());
    }

    public static List<ProductDTOWithId> productToProductDTOWithId(List<Product> products) {
        List<ProductDTOWithId> productDTOWithIdList = new ArrayList<>();
        for (Product product : products) {
            productDTOWithIdList.add(productToProductDTOWithId(product));
        }
        return productDTOWithIdList;
    }
}
