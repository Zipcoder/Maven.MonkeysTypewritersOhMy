package io.zipcoder;

import java.util.Random;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {
    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        Random rm = new Random();
        int rmSleep = rm.nextInt((150-50) + 1)+50;
        while(stringIterator.hasNext()){
            try {
                {
                    synchronized (stringIterator) {
                        String holder = stringIterator.next() + " ";
                        Thread.sleep(rmSleep);
                        System.out.println(Thread.currentThread().getName() + " " + holder);
                        copied = copied + holder;
                    }
                }
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }

        }
        copied = copied.trim();
    }
}
