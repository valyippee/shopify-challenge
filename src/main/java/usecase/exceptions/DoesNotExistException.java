package usecase.exceptions;

/**
 * Exception thrown when an entity does not exist, but was requested.
 */
public class DoesNotExistException extends Exception {

    public DoesNotExistException(String message) {
        super(message);
    }
}
