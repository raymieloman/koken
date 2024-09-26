package nl.acme.koken.bakkerij;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws InterruptedException {
        final Voorraad voorraad = new Voorraad();

        ExecutorService executorService = Executors.newFixedThreadPool(100);
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

//        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);

        System.out.println(voorraad.getVoorraad());
    }
}
