package nl.acme.koken.threads;

public class App {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            Kok kok = new Kok();
            Thread t = new Thread(kok);
            if (i % 5 == 0) {
                t.setPriority(10);
            }
            t.start();
            t.join();
        }

        System.out.println(Thread.currentThread().getName());
    }
}
