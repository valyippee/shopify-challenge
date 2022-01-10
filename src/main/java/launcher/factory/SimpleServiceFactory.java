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

    private ProductCommand cachedProductCommand;
    private ProductRequestBoundary cachedProductGetter;

    private ShipmentCommand cachedShipmentCommand;
    private ShipmentRequestBoundary cachedShipmentGetter;

    public SimpleServiceFactory(RepositoryFactory repositoryFactory) {
        this.productDataAccess = repositoryFactory.makeProductRepository();
        this.shipmentDataAccess = repositoryFactory.makeShipmentRepository();
    }

    @Override
    public ProductCreationBoundary makeProductCreator() {
        if (cachedProductCommand == null) {
            cachedProductCommand = new ProductCommand(productDataAccess);
        }
        return cachedProductCommand;
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
        if (cachedProductCommand == null) {
            cachedProductCommand = new ProductCommand(productDataAccess);
        }
        return cachedProductCommand;
    }

    @Override
    public ProductDeletionBoundary makeProductRemover() {
        if (cachedProductCommand == null) {
            cachedProductCommand = new ProductCommand(productDataAccess);
        }
        return cachedProductCommand;
    }

    @Override
    public ShipmentCreationBoundary makeShipmentCreator() {
        if (cachedShipmentCommand == null) {
            cachedShipmentCommand = new ShipmentCommand(shipmentDataAccess);
        }
        return cachedShipmentCommand;
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
        if (cachedShipmentCommand == null) {
            cachedShipmentCommand = new ShipmentCommand(shipmentDataAccess);
        }
        return cachedShipmentCommand;
    }

    @Override
    public ShipmentDeletionBoundary makeShipmentRemover() {
        if (cachedShipmentCommand == null) {
            cachedShipmentCommand = new ShipmentCommand(shipmentDataAccess);
        }
        return cachedShipmentCommand;
    }
}
