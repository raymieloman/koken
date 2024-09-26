package nl.acme.koken.designpatterns.visitor;

import lombok.ToString;

@ToString
public class FruitCountingVisitor implements  Visitor {
    private int apples;
    private int bananas;

    @Override
    public void visit(Fruitmand mand) {
        for (var fruit : mand) {
            fruit.accept(this);
        }
    }

    @Override
    public void visit(Apple apple) {
            apples++;
    }

    @Override
    public void visit(Banana banana) {
        bananas++;
    }
}
