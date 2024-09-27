package nl.acme.koken.concurrency.bakkerij;


import lombok.Getter;
import nl.acme.koken.assertion.Assertion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Voorraad {
    @Getter
    private int voorraad = 0;

    private Lock lock = new ReentrantLock();
    private Condition not100 = lock.newCondition();
    private Condition notBelowZero = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while(voorraad >=100) {
                not100.await();
            }
            voorraad++;
            Assertion.ensure(voorraad >= 0 );
            notBelowZero.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void decrement()  {
        lock.lock();
        try {
            while (voorraad < 0) {
                notBelowZero.await();
            }
            voorraad--;
            Assertion.ensure(voorraad >= 0 && voorraad <= 100 );
            not100.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
