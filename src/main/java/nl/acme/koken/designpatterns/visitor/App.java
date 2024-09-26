package nl.acme.koken.designpatterns.visitor;

public class App {

    public static void main(String[] args) {

        Fruitmand fruitmand = new Fruitmand();
        fruitmand.add(new Apple());
        fruitmand.add(new Peach());
        fruitmand.add(new Apple());
        fruitmand.add(new Banana());

        Visitor visitor = new FruitCountingVisitor();
        fruitmand.accept(visitor);

        System.out.println(visitor);

    }
}
