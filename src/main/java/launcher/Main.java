package launcher;

import controller.ProductController;
import controller.ShipmentController;
import launcher.factory.RepositoryFactory;
import launcher.factory.ServiceFactory;
import launcher.factory.SimpleRepositoryFactory;
import launcher.factory.SimpleServiceFactory;

public class Main {

    public static void main(String[] args) {
        RepositoryFactory repositoryFactory = new SimpleRepositoryFactory();
        ServiceFactory serviceFactory = new SimpleServiceFactory(repositoryFactory);

        ProductController productController = new ProductController(serviceFactory);
        ShipmentController shipmentController = new ShipmentController(serviceFactory);
        productController.establishAPIRoutes();
        shipmentController.establishAPIRoutes();
    }
}
