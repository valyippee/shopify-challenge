package launcher.factory;

import repository.IdGenerator;
import repository.ProductRepository;
import repository.ShipmentRepository;
import repository.SimpleIdGenerator;
import usecase.dataaccess.ProductDataAccess;
import usecase.dataaccess.ShipmentDataAccess;

/**
 * A factory responsible for creation of repository classes.
 *
 * Returns cached repositories.
 */
public class SimpleRepositoryFactory implements RepositoryFactory {

    private ProductDataAccess cachedProductDataAccess;
    private ShipmentDataAccess cachedShipmentDataAccess;

    private final IdGenerator idGenerator = new SimpleIdGenerator();

    @Override
    public ProductDataAccess makeProductRepository() {
        if (cachedProductDataAccess == null) {
            cachedProductDataAccess = new ProductRepository(idGenerator);
        }
        return cachedProductDataAccess;
    }

    @Override
    public ShipmentDataAccess makeShipmentRepository() {
        if (cachedShipmentDataAccess == null) {
            cachedShipmentDataAccess = new ShipmentRepository(idGenerator);
        }
        return cachedShipmentDataAccess;
    }
}
