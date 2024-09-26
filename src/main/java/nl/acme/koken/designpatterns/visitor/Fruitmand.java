package nl.acme.koken.designpatterns.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Fruitmand extends Fruit implements Iterable<Fruit> {
    private final List<Fruit> content = new ArrayList<>();

    public void add(Fruit fruit) {
        this.content.add(fruit);
    }

    @Override
    public Iterator<Fruit> iterator() {
        return this.content.iterator();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
