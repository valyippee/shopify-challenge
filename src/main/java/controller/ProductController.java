package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import launcher.factory.ServiceFactory;
import usecase.product.*;

import static spark.Spark.*;

/**
 * Exposes endpoints of CRUD services related to {@link entity.Product Product} instances.
 */
public class ProductController {

    private final ProductCreationBoundary productCreationBoundary;
    private final ProductRequestBoundary productRequestBoundary;
    private final ProductUpdateBoundary productUpdateBoundary;
    private final ProductDeletionBoundary productDeletionBoundary;

    private final Gson gson;

    public ProductController(ServiceFactory serviceFactory) {
        this.productCreationBoundary = serviceFactory.makeProductCreator();
        this.productRequestBoundary = serviceFactory.makeProductGetter();
        this.productUpdateBoundary = serviceFactory.makeProductUpdater();
        this.productDeletionBoundary = serviceFactory.makeProductRemover();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting().serializeNulls();
        this.gson = gsonBuilder.create();
    }

    public void establishAPIRoutes() {
        establishGETRoutes();
        establishPUTRoutes();
        establishPOSTRoutes();
        establishDELETERoutes();
    }

    /**
     * Sets up endpoints for HTTP GET requests.
     */
    private void establishGETRoutes() {
        // GET request to retrieve all products
        get("/products", (req, res) -> {
            res.type("application/json");
            return gson.toJson(this.productRequestBoundary.getAllProducts());
        });

        // GET request to retrieve product by id
        get("/products/:id", (req, res) -> {
            res.type("application/json");
            return gson.toJson(this.productRequestBoundary.getProductById(Long.parseLong(req.params(":id"))));
        });

        // GET request to retrieve all products containing a substring
        get("/products/name/:name", (req, res) -> {
            res.type("application/json");
            return gson.toJson(this.productRequestBoundary.getProductsContainingName(req.params(":name")));
        });
    }

    /**
     * Sets up endpoints for HTTP PUT requests.
     */
    private void establishPUTRoutes() {
        put("/products/:id", (req, res) -> {
            res.type("application/json");
            ProductOutputDTO productOutputDTOToEdit = gson.fromJson(req.body(), ProductOutputDTO.class);
            this.productUpdateBoundary.updateProduct(productOutputDTOToEdit);
            return gson.toJson(new StandardResponse(StatusResponse.SUCCESS, "product updated"));
        });
    }

    /**
     * Sets up endpoints for HTTP POST requests.
     */
    private void establishPOSTRoutes() {
        post("/products", (req, res) -> {
            res.type("application/json");
            ProductInputDTO newProductInputDTO = gson.fromJson(req.body(), ProductInputDTO.class);
            this.productCreationBoundary.createProduct(newProductInputDTO);
            return gson.toJson(new StandardResponse(StatusResponse.SUCCESS, "product created"));
        });
    }

    /**
     * Sets up endpoints for HTTP DELETE requests.
     */
    private void establishDELETERoutes() {
        delete("/products/:id", (req, res) -> {
            res.type("application/json");
            this.productDeletionBoundary.deleteProduct(Long.parseLong(req.params(":id")));
            return gson.toJson(new StandardResponse(StatusResponse.SUCCESS, "product deleted"));
        });
    }
}
