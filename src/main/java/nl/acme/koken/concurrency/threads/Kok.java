package nl.acme.koken.concurrency.threads;

public class Kok extends Person implements Runnable {

    @Override
    public void run() {
        System.out.println("Running kok ...");
        System.out.println(Thread.currentThread().getName());
    }
}
