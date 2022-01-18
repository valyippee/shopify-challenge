package controller;

import com.google.gson.JsonElement;
import lombok.Getter;
import lombok.Setter;

/**
 * A response class containing relevant information about the outcome of HTTP requests to the server.
 * Returned as part of the response to HTTP requests.
 */
public class StandardResponse {

    @Getter @Setter
    private StatusResponse status;

    @Getter @Setter
    private String message;

    @Getter @Setter
    private JsonElement data;

    public StandardResponse(StatusResponse status, String message) {
        this.status = status;
        this.message = message;
    }

    public StandardResponse(StatusResponse status, JsonElement data) {
        this.status = status;
        this.data = data;
    }
}
