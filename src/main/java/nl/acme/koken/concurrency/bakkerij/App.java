package nl.acme.koken.concurrency.bakkerij;

import nl.acme.koken.assertion.Assertion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws InterruptedException {
        final Voorraad voorraad = new Voorraad();

        try (ExecutorService executorService = Executors.newFixedThreadPool(100)) {
            for (var i = 0; i < 100; i++) {
                executorService.submit(() -> {
                    Klant klant = new Klant(voorraad);
                    klant.koop();
                });
                executorService.submit(() -> {
                    Bakker bakker = new Bakker(voorraad);
                    bakker.bak();
                });
            }
        }
        System.out.println(voorraad.getVoorraad());
        Assertion.equals(0, voorraad.getVoorraad());
    }
}
