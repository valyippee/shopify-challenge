package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import launcher.factory.ServiceFactory;
import usecase.exceptions.InvalidInputException;
import usecase.shipment.ShipmentDTO;
import usecase.shipment.command.ShipmentCreationBoundary;
import usecase.shipment.query.ShipmentRequestBoundary;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Exposes endpoints of CRUD services related to {@link entity.Shipment Shipment} instances.
 */
public class ShipmentController {

    private final ShipmentCreationBoundary shipmentCreationBoundary;
    private final ShipmentRequestBoundary shipmentRequestBoundary;

    private final Gson gson;

    public ShipmentController(ServiceFactory serviceFactory) {
        this.shipmentCreationBoundary = serviceFactory.makeShipmentCreator();
        this.shipmentRequestBoundary = serviceFactory.makeShipmentGetter();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting().serializeNulls();
        this.gson = gsonBuilder.create();
    }

    /**
     * Sets up all endpoints related to {@link entity.Shipment Shipment} instances
     */
    public void establishAPIRoutes() {
        establishGETRoutes();
        establishPOSTRoutes();
    }

    /**
     * Sets up endpoints for HTTP GET requests.
     */
    private void establishGETRoutes() {
        // GET request to retrieve all products
        get("/shipments", (req, res) -> {
            res.type("application/json");
            return gson.toJson(new StandardResponse(StatusResponse.SUCCESS,
                    gson.toJsonTree(this.shipmentRequestBoundary.getAllShipments())));
        });
    }

    /**
     * Sets up endpoints for HTTP POST requests.
     */
    private void establishPOSTRoutes() {
        post("/shipments", (req, res) -> {
            res.type("application/json");
            ShipmentDTO newShipmentDTO = gson.fromJson(req.body(), ShipmentDTO.class);
            try {
                this.shipmentCreationBoundary.createShipment(newShipmentDTO);
                return gson.toJson(new StandardResponse(StatusResponse.SUCCESS, "product created"));
            } catch (InvalidInputException e) {
                res.status(400);
                return gson.toJson(new StandardResponse(StatusResponse.ERROR, e.getMessage()));
            }

        });
    }

}
