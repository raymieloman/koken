package nl.acme.koken.designpatterns.adapter;

public class App {

    public static void main(String[] args) {
        // Having this peacock
        Peacock myPeacock = new WildPeacock();

        // And I have to convert that to a Duck
        Duck peacockAsDuck = new PeacockAdapter(myPeacock);

        peacockAsDuck.walk();
        peacockAsDuck.quack();
    }
}
