package nl.acme.koken.designpatterns.iterator.square;

import java.util.Iterator;

public class SquareIterator implements Iterator<Integer> {
    private final int max;
    private int current;

    public SquareIterator(int min, int max) {
        this.max = max;
        this.current = min;
    }

    @Override
    public boolean hasNext() {
        return current <= max;
    }

    @Override
    public Integer next() {
        return current*current++;
    }
}
