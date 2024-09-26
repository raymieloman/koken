package nl.acme.koken.bakkerij;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Bakker {
    private Voorraad voorraad;

    public void bak() {
        this.voorraad.increment();
    }
}
