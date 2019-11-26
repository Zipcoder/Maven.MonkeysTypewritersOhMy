package io.zipcoder;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {
   private ReentrantLock lock = new ReentrantLock();

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        Random random = new Random();
        int randomSleep = random.nextInt((100 - 50) + 1) + 50;


        while (stringIterator.hasNext()) {

            try {
                //Do some work
                {
                    synchronized (stringIterator) {
                       // lock.lock();
                        String holder = stringIterator.next() + " ";
                        Thread.sleep(new Random().nextInt(50));
                        System.out.println(Thread.currentThread().getName());
                        copied += holder;
                    }
                }
            } catch (Exception e) {
/*
            } finally {
                lock.unlock();*/
            }
        }
        copied = copied.trim();
    }
}
