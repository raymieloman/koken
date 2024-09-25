package nl.acme.koken.adapter;

public class App {

    public static void main(String[] args) {
        Peacock myPeacock = new WildPeacock();
        Duck peacockAsDuck = new PeacockAdapter(myPeacock);

        peacockAsDuck.walk();
        peacockAsDuck.quack();
    }
}
