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
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productDataAccess.getAllProducts();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            productDTOList.add(ProductMapper.ProductToProductDTO(product));
        }
        return productDTOList;
    }

    @Override
    public ProductDTO getProductById(long productId) {
        return ProductMapper.ProductToProductDTO(productDataAccess.getProductById(productId));
    }

    @Override
    public List<ProductDTO> getProductsContainingName(String name) {
        return null;
    }
}
