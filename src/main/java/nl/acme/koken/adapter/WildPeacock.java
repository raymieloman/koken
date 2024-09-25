package nl.acme.koken.adapter;

public class WildPeacock implements Peacock {
    @Override
    public void run() {
        System.out.println("Running Wild peacock");

    }

    @Override
    public void sound() {
        System.out.println("Oh wauw, oh waus, oh wauw");
    }
}
