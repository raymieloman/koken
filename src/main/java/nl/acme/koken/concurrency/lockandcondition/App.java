package nl.acme.koken.concurrency.lockandcondition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    private static final int POOL_SIZE = 10;

    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer();

        try (ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE)) {
            for (var i = 0; i < POOL_SIZE; i++) {
                int finalI = i;
                executorService.submit(() -> {
                    try {
                        buffer.put(finalI);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
                executorService.submit(() -> {
                    try {
                        System.out.println(buffer.take());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
    }
}