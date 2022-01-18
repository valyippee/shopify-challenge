package repository;

/**
 * An id generator that generates id for entity classes,
 * ensuring that all of its generated ids are unique.
 *
 * Used by {@link repository.ProductRepository} and {@link repository.ShipmentRepository} to
 * assign id values to entities when creating them.
 */
public interface IdGenerator {

    /**
     * Return a unique id that has not been generated before.
     * @return next id
     */
    long getNext();
}
