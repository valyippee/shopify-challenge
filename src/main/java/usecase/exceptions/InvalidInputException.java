package usecase.exceptions;

/**
 * Exception thrown when inputs are not valid when creating entity instances.
 */
public class InvalidInputException extends Exception {

    public InvalidInputException(String message) {
        super(message);
    }
}
