package usecase.product;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * A utility class that maps a {@link entity.Product Product} instance to
 * a {@link ProductWithIdDTO ProductDTO} instance.
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
     *                mapped to a {@link ProductWithIdDTO ProductDTO} instance.
     * @return the corresponding {@link ProductWithIdDTO ProductDTO} instance.
     */
    public static ProductWithIdDTO productToProductWithIdDTO(Product product) {
        return new ProductWithIdDTO(product.getId(), product.getName(),
                product.getDescription(), product.getMinimumRequired(),
                product.getInventoryAtHand());
    }

    public static List<ProductWithIdDTO> productToProductWithIdDTO(List<Product> products) {
        List<ProductWithIdDTO> productWithIdDTOList = new ArrayList<>();
        for (Product product : products) {
            productWithIdDTOList.add(productToProductWithIdDTO(product));
        }
        return productWithIdDTOList;
    }
}
