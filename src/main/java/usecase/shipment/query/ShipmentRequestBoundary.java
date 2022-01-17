package usecase.shipment.query;

import usecase.shipment.ShipmentDTOWithIdAndStatus;

import java.util.List;

public interface ShipmentRequestBoundary {
    List<ShipmentDTOWithIdAndStatus> getAllShipments();
}
