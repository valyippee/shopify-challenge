package usecase.product;

import entity.Product;
import usecase.dataaccess.ProductDataAccess;

import java.util.ArrayList;
import java.util.List;

/**
 * A use case class responsible for retrieving data related to
 * {@link entity.Product Product} instances.
 */
public class ProductGetter implements ProductRequestBoundary {

    private final ProductDataAccess productDataAccess;

    public ProductGetter(ProductDataAccess productDataAccess) {
        this.productDataAccess = productDataAccess;
    }

    @Override
    public List<ProductOutputDTO> getAllProducts() {
        List<Product> productList = productDataAccess.getAllProducts();
        List<ProductOutputDTO> productOutputDTOList = new ArrayList<>();
        for (Product product : productList) {
            productOutputDTOList.add(ProductMapper.productToProductDTO(product));
        }
        return productOutputDTOList;
    }

    @Override
    public ProductOutputDTO getProductById(long productId) {
        return ProductMapper.productToProductDTO(productDataAccess.getProductById(productId));
    }

    @Override
    public List<ProductOutputDTO> getProductsContainingName(String name) {
        return ProductMapper.productToProductDTO(productDataAccess.getProductsContainingName(name));
    }
}
