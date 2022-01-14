package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import launcher.factory.ServiceFactory;
import spark.Filter;
import usecase.exceptions.DoesNotExistException;
import usecase.exceptions.InvalidInputException;
import usecase.product.command.ProductCreationBoundary;
import usecase.product.ProductDTO;
import usecase.product.command.ProductDeletionBoundary;
import usecase.product.command.ProductUpdateBoundary;
import usecase.product.ProductWithIdDTO;
import usecase.product.query.ProductRequestBoundary;

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
        after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });

        // GET request to retrieve all products
        get("/products", (req, res) -> {
            res.type("application/json");
            return gson.toJson(new StandardResponse(StatusResponse.SUCCESS,
                    gson.toJsonTree(this.productRequestBoundary.getAllProducts())));
        });

        // GET request to retrieve product by id
        get("/products/:id", (req, res) -> {
            res.type("application/json");
            try {
                ProductWithIdDTO product = this.productRequestBoundary.getProductById(Long.parseLong(req.params(":id")));
                return gson.toJson(new StandardResponse(StatusResponse.ERROR, gson.toJson(product)));
            } catch (DoesNotExistException e) {
                return gson.toJson(new StandardResponse(StatusResponse.ERROR, e.getMessage()));
            }
        });

        // GET request to retrieve all products containing a substring
        get("/products/name/:name", (req, res) -> {
            res.type("application/json");
            return gson.toJson(new StandardResponse(StatusResponse.SUCCESS,
                    gson.toJsonTree(this.productRequestBoundary.getProductsContainingName(req.params(":name")))));
        });
    }

    /**
     * Sets up endpoints for HTTP PUT requests.
     */
    private void establishPUTRoutes() {
        put("/products/:id", (req, res) -> {
            res.type("application/json");
            ProductWithIdDTO productInputDTOToEdit = gson.fromJson(req.body(), ProductWithIdDTO.class);
            if (Long.parseLong(req.params(":id")) != productInputDTOToEdit.getId()) {
                return gson.toJson(new StandardResponse(StatusResponse.ERROR, "Requested product id " +
                        "does not match id of given product's details"));
            }
            try {
                this.productUpdateBoundary.updateProduct(productInputDTOToEdit);
                return gson.toJson(new StandardResponse(StatusResponse.SUCCESS, "product updated"));
            } catch (DoesNotExistException | InvalidInputException e) {
                return gson.toJson(new StandardResponse(StatusResponse.ERROR, e.getMessage()));
            }

        });
    }

    /**
     * Sets up endpoints for HTTP POST requests.
     */
    private void establishPOSTRoutes() {
        post("/products", (req, res) -> {
            res.type("application/json");
            ProductDTO newProductDTO = gson.fromJson(req.body(), ProductDTO.class);
            this.productCreationBoundary.createProduct(newProductDTO);
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
