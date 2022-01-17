package usecase.shipment.query;

import entity.Shipment;
import usecase.dataaccess.ShipmentDataAccess;
import usecase.shipment.ShipmentDTOWithIdAndStatus;
import usecase.shipment.ShipmentMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * A use case class responsible for retrieving data related to
 * {@link entity.Shipment Shipment} instances.
 */
public class ShipmentQueryService implements ShipmentRequestBoundary {
    private final ShipmentDataAccess shipmentDataAccess;

    public ShipmentQueryService(ShipmentDataAccess shipmentDataAccess) {
        this.shipmentDataAccess = shipmentDataAccess;
    }

    @Override
    public List<ShipmentDTOWithIdAndStatus> getAllShipments() {
        List<Shipment> shipmentList = shipmentDataAccess.getAllShipments();
        List<ShipmentDTOWithIdAndStatus> shipmentDTOList = new ArrayList<>();
        for (Shipment shipment : shipmentList) {
            shipmentDTOList.add(ShipmentMapper.shipmentToShipmentDTOWithDetails(shipment));
        }
        return shipmentDTOList;
    }
}
