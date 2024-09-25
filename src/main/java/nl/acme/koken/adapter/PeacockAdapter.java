package nl.acme.koken.adapter;

public class PeacockAdapter implements Duck {
    private Peacock peacock;

    public PeacockAdapter(Peacock peacock) {
        this.peacock = peacock;
    }

    @Override
    public void walk() {
        this.peacock.run();
    }

    @Override
    public void quack() {
        this.peacock.sound();
    }
}
