package nl.acme.koken.designpatterns.visitor;

public interface Visitor {
    void visit(Fruitmand mand);
    void visit(Apple apple);
    void visit(Banana banana);
    void visit(Peach peach);
}
