package usecase.product.query;

import entity.Product;
import usecase.dataaccess.ProductDataAccess;
import usecase.exceptions.DoesNotExistException;
import usecase.product.ProductMapper;
import usecase.product.ProductDTOWithId;

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
    public List<ProductDTOWithId> getAllProducts() {
        List<Product> productList = productDataAccess.getAllProducts();
        List<ProductDTOWithId> productDTOWithIdList = new ArrayList<>();
        for (Product product : productList) {
            productDTOWithIdList.add(ProductMapper.productToProductDTOWithId(product));
        }
        return productDTOWithIdList;
    }

    @Override
    public ProductDTOWithId getProductById(long productId) throws DoesNotExistException {
        return ProductMapper.productToProductDTOWithId(productDataAccess.getProductById(productId));
    }

    @Override
    public List<ProductDTOWithId> getProductsContainingName(String name) {
        return ProductMapper.productToProductDTOWithId(productDataAccess.getProductsContainingName(name));
    }
}
