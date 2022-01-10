package launcher.factory;

import usecase.dataaccess.ProductDataAccess;
import usecase.dataaccess.ShipmentDataAccess;
import usecase.product.*;
import usecase.shipment.*;

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
            cachedProductGetter = new ProductGetter(productDataAccess);
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
            cachedShipmentGetter = new ShipmentGetter(shipmentDataAccess);
        }
        return cachedShipmentGetter;
    }

    @Override
    public ShipmentUpdateBoundary makeShipmentUpdater() {
        if (cachedShipmentCommandService == null) {
            cachedShipmentCommandService = new ShipmentCommandService(shipmentDataAccess);
        }
        return cachedShipmentCommandService;
    }

    @Override
    public ShipmentDeletionBoundary makeShipmentRemover() {
        if (cachedShipmentCommandService == null) {
            cachedShipmentCommandService = new ShipmentCommandService(shipmentDataAccess);
        }
        return cachedShipmentCommandService;
    }
}
