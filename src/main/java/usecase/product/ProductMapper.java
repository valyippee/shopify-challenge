package usecase.product;

import entity.Product;
import usecase.product.query.ProductInputDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * A utility class that maps a {@link entity.Product Product} instance to
 * a {@link ProductInputDTO ProductDTO} instance.
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
     *                mapped to a {@link ProductInputDTO ProductDTO} instance.
     * @return the corresponding {@link ProductInputDTO ProductDTO} instance.
     */
    public static ProductInputDTO productToProductDTO(Product product) {
        return new ProductInputDTO(product.getId(), product.getName(),
                product.getDescription(), product.getMinimumRequired(),
                product.getInventoryAtHand());
    }

    public static List<ProductInputDTO> productToProductDTO(List<Product> products) {
        List<ProductInputDTO> productInputDTOList = new ArrayList<>();
        for (Product product : products) {
            productInputDTOList.add(productToProductDTO(product));
        }
        return productInputDTOList;
    }
}
