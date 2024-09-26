package nl.acme.koken.designpatterns.iterator.square;

import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        Iterator squareIterator = new SquareIterator(1, 5);

        while(squareIterator.hasNext()) {
            System.out.println(squareIterator.next());
        }
    }
}
