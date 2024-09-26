package nl.acme.koken.designpatterns.visitor;

public class Peach extends Fruit {

    @Override
    public void accept(Visitor visitor) {
            visitor.visit(this);
    }
}
