package nl.acme.koken.designpatterns.visitor;

import lombok.Data;

@Data
public abstract class Fruit {
    public abstract void accept(Visitor visitor);
}
