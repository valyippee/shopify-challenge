package launcher.factory;

import usecase.dataaccess.ProductDataAccess;
import usecase.dataaccess.ShipmentDataAccess;
import usecase.product.command.ProductCommandService;
import usecase.product.command.ProductCreationBoundary;
import usecase.product.command.ProductDeletionBoundary;
import usecase.product.command.ProductUpdateBoundary;
import usecase.product.query.ProductQueryService;
import usecase.product.query.ProductRequestBoundary;
import usecase.shipment.command.ShipmentCommandService;
import usecase.shipment.command.ShipmentCreationBoundary;
import usecase.shipment.query.ShipmentQueryService;
import usecase.shipment.query.ShipmentRequestBoundary;

/**
 * A factory responsible for creation of service classes.
 */
public class SimpleServiceFactory implements ServiceFactory {

    private final ProductDataAccess productDataAccess;
    private final ShipmentDataAccess shipmentDataAccess;

    private ProductCommandService cachedProductCommandService;
    private ProductRequestBoundary cachedProductGetter;

    private ShipmentCommandService cachedShipmentCommandService;
    private ShipmentRequestBoundary cachedShipmentGetter;

    public SimpleServiceFactory(RepositoryFactory repositoryFactory) {
        this.productDataAccess = repositoryFactory.makeProductRepository();
        this.shipmentDataAccess = repositoryFactory.makeShipmentRepository();
    }

    @Override
    public ProductCreationBoundary makeProductCreator() {
        if (cachedProductCommandService == null) {
            cachedProductCommandService = new ProductCommandService(productDataAccess);
        }
        return cachedProductCommandService;
    }

    @Override
    public ProductRequestBoundary makeProductGetter() {
        if (cachedProductGetter == null) {
            cachedProductGetter = new ProductQueryService(productDataAccess);
        }
        return cachedProductGetter;
    }

    @Override
    public ProductUpdateBoundary makeProductUpdater() {
        if (cachedProductCommandService == null) {
            cachedProductCommandService = new ProductCommandService(productDataAccess);
        }
        return cachedProductCommandService;
    }

    @Override
    public ProductDeletionBoundary makeProductRemover() {
        if (cachedProductCommandService == null) {
            cachedProductCommandService = new ProductCommandService(productDataAccess);
        }
        return cachedProductCommandService;
    }

    @Override
    public ShipmentCreationBoundary makeShipmentCreator() {
        if (cachedShipmentCommandService == null) {
            cachedShipmentCommandService = new ShipmentCommandService(shipmentDataAccess);
        }
        return cachedShipmentCommandService;
    }

    @Override
    public ShipmentRequestBoundary makeShipmentGetter() {
        if (cachedShipmentGetter == null) {
            cachedShipmentGetter = new ShipmentQueryService(shipmentDataAccess);
        }
        return cachedShipmentGetter;
    }
}
