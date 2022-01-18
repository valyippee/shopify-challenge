package launcher.factory;

import usecase.dataaccess.ProductDataAccess;
import usecase.dataaccess.ShipmentDataAccess;

/**
 * A factory responsible for making repositories.
 */
public interface RepositoryFactory {
    ProductDataAccess makeProductRepository();
    ShipmentDataAccess makeShipmentRepository();
}
