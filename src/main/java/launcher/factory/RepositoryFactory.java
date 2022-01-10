package launcher.factory;

import usecase.dataaccess.ProductDataAccess;
import usecase.dataaccess.ShipmentDataAccess;

public interface RepositoryFactory {
    ProductDataAccess makeProductRepository();
    ShipmentDataAccess makeShipmentRepository();
}
