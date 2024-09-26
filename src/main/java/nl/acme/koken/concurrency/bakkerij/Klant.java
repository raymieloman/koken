package nl.acme.koken.concurrency.bakkerij;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Klant {
    private Voorraad voorraad;

    public void koop() {
        this.voorraad.decrement();
    }
}
