package nl.acme.koken.designpatterns.iterable;

public class App {

    public static void main(String[] args) {
        Fruitmand mand = new Fruitmand();
        mand.add(new Fruit("Apple"));
        mand.add(new Fruit("Pear"));
        mand.add(new Fruit("Banana"));

        for(Fruit fruit : mand) {
            System.out.println(fruit);
        }
    }
}
