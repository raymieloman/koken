package nl.acme.koken.bakkerij;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Klant {
    private Voorraad voorraad;

    public void koop() {
        this.voorraad.decrement();
    }
}
