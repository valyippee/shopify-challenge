package repository;

public class SimpleIdGenerator implements IdGenerator {
    private int counter = 0;

    @Override
    public long getNext() {
        return counter++;
    }
}
