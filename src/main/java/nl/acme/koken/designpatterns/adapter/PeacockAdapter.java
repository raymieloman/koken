package nl.acme.koken.designpatterns.adapter;

public class PeacockAdapter implements Duck {
    private final Peacock peacock;

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
