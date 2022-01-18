package repository;

/**
 * A simple implementation of {@link repository.IdGenerator} by use of a counter.
 */
public class SimpleIdGenerator implements IdGenerator {
    private int counter = 0;

    /**
     * Return the current counter value as the next id and increments counter.
     * @return next id
     */
    @Override
    public long getNext() {
        return counter++;
    }
}
