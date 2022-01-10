package launcher.factory;

import usecase.product.ProductCreationBoundary;
import usecase.product.ProductDeletionBoundary;
import usecase.product.ProductRequestBoundary;
import usecase.product.ProductUpdateBoundary;
import usecase.shipment.ShipmentCreationBoundary;
import usecase.shipment.ShipmentDeletionBoundary;
import usecase.shipment.ShipmentRequestBoundary;
import usecase.shipment.ShipmentUpdateBoundary;

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

    /**
     * @return a use case class responsible for updating existing
     * {@link entity.Shipment Shipment} instances.
     */
    ShipmentUpdateBoundary makeShipmentUpdater();

    /**
     * @return a use case class responsible for removing existing
     * {@link entity.Shipment Shipment} instances.
     */
    ShipmentDeletionBoundary makeShipmentRemover();
}
