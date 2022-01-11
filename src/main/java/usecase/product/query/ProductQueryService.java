package usecase.product.query;

import entity.Product;
import usecase.dataaccess.ProductDataAccess;
import usecase.product.ProductMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * A use case class responsible for retrieving data related to
 * {@link entity.Product Product} instances.
 */
public class ProductQueryService implements ProductRequestBoundary {

    private final ProductDataAccess productDataAccess;

    public ProductQueryService(ProductDataAccess productDataAccess) {
        this.productDataAccess = productDataAccess;
    }

    @Override
    public List<ProductInputDTO> getAllProducts() {
        List<Product> productList = productDataAccess.getAllProducts();
        List<ProductInputDTO> productInputDTOList = new ArrayList<>();
        for (Product product : productList) {
            productInputDTOList.add(ProductMapper.productToProductDTO(product));
        }
        return productInputDTOList;
    }

    @Override
    public ProductInputDTO getProductById(long productId) {
        return ProductMapper.productToProductDTO(productDataAccess.getProductById(productId));
    }

    @Override
    public List<ProductInputDTO> getProductsContainingName(String name) {
        return ProductMapper.productToProductDTO(productDataAccess.getProductsContainingName(name));
    }
}
