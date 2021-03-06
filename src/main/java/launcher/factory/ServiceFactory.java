package launcher.factory;

import usecase.product.command.ProductCreationBoundary;
import usecase.product.command.ProductDeletionBoundary;
import usecase.product.query.ProductRequestBoundary;
import usecase.product.command.ProductUpdateBoundary;
import usecase.shipment.command.ShipmentCreationBoundary;
import usecase.shipment.query.ShipmentRequestBoundary;

/**
 * A factory responsible for making service classes.
 */
public interface ServiceFactory {

    /**
     * @return a use case class responsible for creating new
     * {@link entity.Product Product} instances.
     */
    ProductCreationBoundary makeProductCreator();

    /**
     * @return a use case class responsible for retrieving
     * {@link entity.Product Product} instances.
     */
    ProductRequestBoundary makeProductGetter();

    /**
     * @return a use case class responsible for updating existing
     * {@link entity.Product Product} instances.
     */
    ProductUpdateBoundary makeProductUpdater();

    /**
     * @return a use case class responsible for removing existing
     * {@link entity.Product Product} instances.
     */
    ProductDeletionBoundary makeProductRemover();

    /**
     * @return a use case class responsible for creating new
     * {@link entity.Shipment Shipment} instances.
     */
    ShipmentCreationBoundary makeShipmentCreator();

    /**
     * @return a use case class responsible for retrieving
     * {@link entity.Shipment Shipment} instances.
     */
    ShipmentRequestBoundary makeShipmentGetter();
}
