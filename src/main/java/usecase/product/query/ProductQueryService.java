package usecase.product.query;

import entity.Product;
import usecase.dataaccess.ProductDataAccess;
import usecase.exceptions.DoesNotExistException;
import usecase.product.ProductMapper;
import usecase.product.ProductWithIdDTO;

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
    public List<ProductWithIdDTO> getAllProducts() {
        List<Product> productList = productDataAccess.getAllProducts();
        List<ProductWithIdDTO> productWithIdDTOList = new ArrayList<>();
        for (Product product : productList) {
            productWithIdDTOList.add(ProductMapper.productToProductWithIdDTO(product));
        }
        return productWithIdDTOList;
    }

    @Override
    public ProductWithIdDTO getProductById(long productId) throws DoesNotExistException {
        return ProductMapper.productToProductWithIdDTO(productDataAccess.getProductById(productId));
    }

    @Override
    public List<ProductWithIdDTO> getProductsContainingName(String name) {
        return ProductMapper.productToProductWithIdDTO(productDataAccess.getProductsContainingName(name));
    }
}
