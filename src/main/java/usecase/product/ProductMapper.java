package usecase.product;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * A utility class that maps a {@link entity.Product Product} instance to
 * a {@link ProductOutputDTO ProductDTO} instance.
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
     *                mapped to a {@link ProductOutputDTO ProductDTO} instance.
     * @return the corresponding {@link ProductOutputDTO ProductDTO} instance.
     */
    public static ProductOutputDTO productToProductDTO(Product product) {
        return new ProductOutputDTO(product.getId(), product.getName(),
                product.getDescription(), product.getMinimumRequired(),
                product.getInventoryAtHand());
    }

    public static List<ProductOutputDTO> productToProductDTO(List<Product> products) {
        List<ProductOutputDTO> productOutputDTOList = new ArrayList<>();
        for (Product product : products) {
            productOutputDTOList.add(productToProductDTO(product));
        }
        return productOutputDTOList;
    }
}
